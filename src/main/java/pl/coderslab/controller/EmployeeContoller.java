package pl.coderslab.controller;


import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.awt.*;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.EmployeeDTO;
import pl.coderslab.dto.OrderDTO;
import pl.coderslab.entity.*;
import pl.coderslab.entity.security.User;
import pl.coderslab.repository.*;
import pl.coderslab.repository.security.UserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static com.itextpdf.kernel.pdf.PdfName.BaseFont;


@SuppressWarnings("ResultOfMethodCallIgnored")
@Controller
public class EmployeeContoller {
    public static final String DEST = "results/chapter01/Raport.pdf";

    @Autowired
    private GroupsRepository gr;
    @Autowired
    private UserRepository ur;
    @Autowired
    private IteamsRepository ir;
    @Autowired
    private OrderRepository or;
    @Autowired
    private EmployeeRepository er;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private WarehouseKindRepository warehouseKindRepository;
    @Autowired
    private WarehouseStatusRepository warehouseStatusRepository;

@GetMapping("/group")
public String groups(){
    return ("groups");
}

@GetMapping("/employee/{grpid}")
public String employee(@PathVariable long grpid , Model model){
    groups grp = this.gr.findOne(grpid);
    List<Employee> employees = this.er.findAllByGroup(grp);

    model.addAttribute("employees",employees.stream().map(EmployeeDTO::new).collect(Collectors.toList()));
    return "employ";
}

    @GetMapping("/warehouse")
    public String warehousePanel(){
        return ("employ/warehouse");
    }
    @GetMapping("/warehouseItem")
    public String warehouseItem(){
        return ("employ/warehouseItem");
    }



    @GetMapping("/warehouse/status/{id}")
    public String editWarehouse(Model model, @PathVariable long id){

        model.addAttribute("work",this.warehouseRepository.findOne(id));
        return "employ/warehouse/addForm";
    }

    @PostMapping("/warehouse/status/{id}")
    public String editWarehousePost(@ModelAttribute Warehouse warehouse1, HttpServletRequest request){
        Warehouse warehouse = warehouseRepository.findOne(warehouse1.getId());
        warehouse.setIlosc((warehouse.getIlosc() - warehouse1.getIlosc()));
        if(warehouse.getName().contains("surowiec") && warehouse.getIlosc() > 1000
                || warehouse.getWarehouseKind().getId() == 1 && warehouse.getIlosc() > 1000){
            warehouse.setWarehouseStatus(warehouseStatusRepository.findOne(1l));
        }
        else if(warehouse.getName().contains("surowiec") && warehouse.getIlosc() <= 1000
                || warehouse.getWarehouseKind().getId() == 1 && warehouse.getIlosc() <= 1000){
            warehouse.setWarehouseStatus(warehouseStatusRepository.findOne(2l));
        }
        else if(!warehouse.getName().contains("surowiec") && warehouse.getWarehouseKind().getId() == 2  && warehouse.getIlosc() > 400){
            warehouse.setWarehouseStatus(warehouseStatusRepository.findOne(1l));
        }
        else{
            warehouse.setWarehouseStatus(warehouseStatusRepository.findOne(2l));

        }
        if(warehouse.getWarehouseStatus().getId() == 2 && warehouse.getWarehouseKind().getId() == 2){
            String masagge = "\n\n   Zgłaszam brak półproduktu jakim jest" + warehouse.getName() + " jest nam to potrzebna dlatego prosze \" +\n" +
                    "                    \" o złożenie odpowiedzniego zamówienia na potrzebny nam półprodukt \" +\n" +
                    "                    \"\n\n Pozdrawiam\");\n";
            sendMail(warehouse.getEmployee().getUser() , masagge);
        }
        else if(warehouse.getWarehouseStatus().getId() == 2 && warehouse.getWarehouseKind().getId() == 1) {
            String masagge = "\\n\\n   \"Zgłaszam brak produktu jakim jest" + warehouse.getName() + "brakuje nam zapasów w razie jakiegos zamówienia. \"" +
                    "                    \\n \" Prosiłbym o przygotowanie odpowiedniego zamówienia na produkcje  \" +\n" +
                    "                    \"\\n\\n Pozdrawiam\");\n";
            sendMail(warehouse.getEmployee().getUser(), masagge);
        }
        this.warehouseRepository.save(warehouse);

        return "redirect:../../warehouse";
    }


    public void sendMail(User user, String mail){
        final String username = "szumika12@gmail.com";
        final String pass = "qwopASKL!@";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, pass);
                    }
                });

        message(session,"szumika12@gmail.com",user, mail);
    }


    public void message(Session session, String email , User user, String mail){
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Zamowienie");
            message.setText("Witaj "+ user.getUsername() +","
                    + mail);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


    @GetMapping("/raport")
    public String raport(@Valid Item item, BindingResult result,Model m){
        m.addAttribute("itemR",new Item());
        return "addFormRaport";
    }

    @PostMapping("/raport")
    public String raports(@Valid Item item, BindingResult result, Model m, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(result.hasErrors()){
            return "addFormRaport";
        }
        String date1 = request.getParameter("date1") + " 00:00:00";
        String date2 = request.getParameter("date2") + " 23:59:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeStart = LocalDateTime.parse(date1, formatter);
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date2, formatter);



        List<Item> items = new ArrayList<>();
        String[] st = item.getName().split(",");
        for (int x=0; x<st.length; x++){
            System.out.println(st[x]);
            items.add(ir.findByNameContaining(st[x]));
    }
    List<Orders> orders = or.findByItemInAndCreatedIsGreaterThanEqualAndCreatedIsLessThanEqual(items,dateTimeStart,dateTimeEnd);
        List<OrderDTO> orderDTOS = orders.stream().map(or -> new OrderDTO(or)).collect(Collectors.toList());
        m.addAttribute("ordersRa",orderDTOS);

            return  "employ/ordered";
    }


    @GetMapping("/results")
    public String raportResults(@PathVariable List<String> names, HttpServletRequest request){
    List<String> str = new ArrayList<>();
        for (int x=0; x<names.size(); x++) {


        }
        System.out.println(str.toString());
        return "employ/warehouseItem";
    }

    @ModelAttribute("itemsR")
    public List<Item> item(){
        return  this.ir.findAll();
    }
    @ModelAttribute("warehouseP")
    public List<Warehouse> warehouse (){
        return this.warehouseRepository.findByWarehouseKind(warehouseKindRepository.findOne(1l)); }
    @ModelAttribute("warehousePP")
    public List<Warehouse> warehousePP (){
        return this.warehouseRepository.findByWarehouseKind(warehouseKindRepository.findOne(2l)); }
    @ModelAttribute("groups")
    public List<groups> grp(){
    return this.gr.findAll();
}
    @ModelAttribute("employee")
    public List<Employee> emplo(){
    return this.er.findAll();
}
}
