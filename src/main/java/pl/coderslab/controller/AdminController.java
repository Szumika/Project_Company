package pl.coderslab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.entity.security.User;
import pl.coderslab.repository.*;
import pl.coderslab.repository.security.UserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@Controller
public class AdminController {

    private final UserRepository ur;
    private final OrderRepository or;
    private final GroupsRepository gr;
    private final EmployeeRepository er;
    private final NewsRepository nr;
    private final IteamsRepository ir;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseKindRepository warehouseKindRepository;
    private final WarehouseStatusRepository warehouseStatusRepository;
    public AdminController(UserRepository ur, OrderRepository or, GroupsRepository gr, EmployeeRepository er, NewsRepository nr, IteamsRepository ir, WarehouseRepository warehouseRepository, WarehouseKindRepository warehouseKindRepository, WarehouseStatusRepository warehouseStatusRepository) {
        this.ur = ur;
        this.or = or;
        this.gr = gr;
        this.er = er;
        this.nr = nr;
        this.ir = ir;
        this.warehouseRepository = warehouseRepository;
        this.warehouseKindRepository = warehouseKindRepository;
        this.warehouseStatusRepository = warehouseStatusRepository;
    }

    @GetMapping("/admin")
    public String admins(){
    return "admin/admin";
}

    @GetMapping("/employ")
    public String eplooyee(){
        return "employ/employ";
    }



    @GetMapping("/warehouseA")
    public String warkhosueA(Model model){
        model.addAttribute("warehouse", this.warehouseRepository.findAll());
        return "admin/warehouse";
    }

    // ------------------- edycja grupy
    @GetMapping("/warehouse/edit/{id}")
    public String editWarehouse(Model model, @PathVariable long id){

        model.addAttribute("work",this.warehouseRepository.findOne(id));
        return "admin/warehouse/addForm";
    }

    @PostMapping("/warehouse/edit/{id}")
    public String editWarehousePost(@ModelAttribute Warehouse warehouse1, HttpServletRequest request){
        Warehouse warehouse = warehouseRepository.findOne(warehouse1.getId());
        warehouse.setName(warehouse1.getName());
        warehouse.setIlosc(warehouse1.getIlosc());
        String	param	= request.getParameter("toppings");
        if(param != null){
            long id = Long.parseLong(param);
            WarehouseKind warehouseKind = warehouseKindRepository.findOne(id);
            warehouse.setWarehouseKind(warehouseKind);
        }
        createAndEditWarehouse(warehouse);

        return "redirect:../../warehouseA";
    }

    public void createAndEditWarehouse(Warehouse warehouse){
        if(warehouse.getWarehouseKind().getId() == 1){
            warehouse.setEmployee(er.findOne(2l));
        }
        else{
            warehouse.setEmployee(er.findOne(1l));
        }
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
        else if(warehouse.getWarehouseStatus().getId() == 2 && warehouse.getWarehouseKind().getId() == 1){
            String masagge = "\\n\\n   \"Zgłaszam brak produktu jakim jest" + warehouse.getName() + "brakuje nam zapasów w razie jakiegos zamówienia. \"" +
                    "                    \\n \" Prosiłbym o przygotowanie odpowiedniego zamówienia na produkcje  \" +\n" +
                    "                    \"\\n\\n Pozdrawiam\");\n";
            sendMail(warehouse.getEmployee().getUser() , masagge);
        }
        this.warehouseRepository.save(warehouse);
    }

    @GetMapping("/add/warehouse")
    public String addwarehouse(Model model){
        model.addAttribute("work",new Warehouse());
        return "admin/warehouse/addForm";
    }

    @PostMapping("/add/warehouse")
    public String addwarehousePost(@ModelAttribute Warehouse warehouse, HttpServletRequest request){
        String	param	= request.getParameter("toppings");
        if(param != null){
            long id = Long.parseLong(param);
            WarehouseKind warehouseKind = warehouseKindRepository.findOne(id);
            warehouse.setWarehouseKind(warehouseKind);
        }
        else{
            warehouse.setWarehouseKind(warehouseKindRepository.findOne(2l));
        }
        createAndEditWarehouse(warehouse);
        return "redirect:../warehouseA";
    }


    @GetMapping("/warehousdel/{id}")
    public String nwarehouseDel(@PathVariable long id){
        warehouseRepository.delete(id);
        return "redirect:../warehouseA";
    }


@GetMapping("/ordered")
    public String ordered(){
    return "admin/ordered";
}


@GetMapping("/groups")
    public String grp(){
    return "admin/groups";
}

// ------------------- edycja grupy
    @GetMapping("/grp/edit/{id}")
    public String editgrp(Model model, @PathVariable long id, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        model.addAttribute("group",this.gr.findOne(id));
        return "admin/group/addForm";
    }

    @PostMapping("/grp/edit/{id}")
    public String editgrppost(@ModelAttribute groups groups,HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        gr.save(groups);
        return "redirect:../../groups";
    }


    @GetMapping("/employeeadmin/{grpid}")
    public String employee(@PathVariable long grpid , Model model){
        groups grp = this.gr.findOne(grpid);
        List<Employee> employees = this.er.findAllByGroup(grp);
        model.addAttribute("employees",employees);
        return "admin/employadmin";
    }
    // ------------------------------ edycja pracownika
    @GetMapping("/emplo/edit/{id}")
    public String editemplo(Model model, @PathVariable long id){

        model.addAttribute("employee",this.er.findOne(id));
        return "admin/emplo/addForm";
    }
    @PostMapping("/emplo/edit/{id}")
    public String editemplopost(@ModelAttribute Employee employee){
        employee.setSalary((employee.getHoursPerMonth())*(employee.getSalaryPerHouer()));
        er.save(employee);
        return "admin/groups";
    }


    @GetMapping("/delorder/{id}")
    public String del(@PathVariable long id){
    or.delete(id);
    return "redirect:../ordered";
    }


    @GetMapping("/newsadmin")
    public String news(){
        return "admin/newsadmin";
    }


// ------------------------ dodawanie aktualnosci
    @GetMapping("/add/news")
    public String add(Model model){
    model.addAttribute("news",new news());
    return "admin/news/addForm";
    }

    @PostMapping("/add/news")
    public String addpost(@ModelAttribute news news){
    news.setCreated(LocalDateTime.now());
    this.nr.save(news);
    return "redirect:../newsadmin";
    }


    @GetMapping("/newsdel/{id}")
    public String newsdel(@PathVariable long id){
        nr.delete(id);
        return "redirect:../newsadmin";
    }


    @GetMapping("/news/edit/{id}")
    public String editnews(Model model, @PathVariable long id){

        model.addAttribute("news",this.nr.findOne(id));
        return "admin/news/addForm";
    }

    @PostMapping("/news/edit/{id}")
    public String editnewspost(@ModelAttribute news news){
        nr.save(news);
        return "redirect:../../newsadmin";
    }


    @GetMapping("/itemsadmin")
    public String items(){
    return "admin/itemsadmin";
    }


    @GetMapping("/add/items")
    public String additems(Model model){
        model.addAttribute("item",new Item());
        return "admin/items/addForm";
    }

    @PostMapping("/add/items")
    public String additemspost(@ModelAttribute Item item){
        this.ir.save(item);
        return "redirect:../../itemsadmin";
    }


    @GetMapping("/item/del/{id}")
    public String itemdel(@PathVariable long id){
        ir.delete(id);
        return "redirect:../../itemsadmin";
    }


    @GetMapping("/item/edit/{id}")
    public String edititem(Model model, @PathVariable long id){

        model.addAttribute("item",this.ir.findOne(id));
        return "admin/items/addForm";
    }

    @PostMapping("/item/edit/{id}")
    public String edititempost(@ModelAttribute Item item){
        ir.save(item);
        return "redirect:../../itemsadmin";
    }


    @GetMapping("/status/edit/{id}")
    public String editstatu(Model model, @PathVariable long id){
    Orders order = this.or.findOne(id);
    String masagge = "\\n\\n Wlasnie skompletowalismy twoje zamówienie, czeka na odbiór. W sprawie dostarczenia\" +\n" +
            "                    \" zamówienie na konkretny adres prosze kontaktowac sie z biurem na nr 600-600-600\" +\n" +
            "                    \"\\n\\n Pozdrawiamy\");\n";
    sendMail(order.getUser() , masagge);
    order.setStatus("gotowy");

    or.save(order);
        return "redirect:../../ordered";
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


    @ModelAttribute("kind")
    public List<WarehouseKind> kind(){return  this.warehouseKindRepository.findAll(); }
    @ModelAttribute("orders")
    public List<Orders> orders(){
        return this.or.findAll();
}
    @ModelAttribute("groups1")
    public List<groups> groups(){
        return this.gr.findAll();
    }
    @ModelAttribute("employees")
    public List<Employee> emplo(){
        return this.er.findAll();
    }
    @ModelAttribute("news1")
    public List<news> newses(){
        return this.nr.findAll();
    }
    @ModelAttribute("items")
    public List<Item> item(){
        return  this.ir.findAll();
    }}
