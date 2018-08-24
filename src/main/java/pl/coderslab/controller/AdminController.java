package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.*;
import pl.coderslab.entity.security.User;
import pl.coderslab.repository.*;
import pl.coderslab.repository.security.UserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@Controller
public class AdminController {
    @Autowired
    private UserRepository ur;
    @Autowired
    private OrderRepository or;
    @Autowired
    private GroupsRepository gr;
    @Autowired
    private EmployeeRepository er;
    @Autowired
    private NewsRepository nr;
    @Autowired
    private IteamsRepository ir;

@GetMapping("/admin")
    public String admins(){
    return "admin/admin";
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
    public String editgrp(Model model, @PathVariable long id){

        model.addAttribute("group",this.gr.findOne(id));
        return "admin/group/addForm";
    }

    @PostMapping("/grp/edit/{id}")
    public String editgrppost(@ModelAttribute groups group){
        gr.save(group);
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
    public String editstatu(Model model, @PathVariable long id, Authentication auth){
    Orders order = this.or.findOne(id);
        order.setStatus("gotowy");
        final String username = "szumika12@gmail.com";
        final String pass = "qwopASKL!@";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, pass);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("szumika12@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(order.getUser().getEmail()));
            message.setSubject("Zamowienie");
            message.setText("Witaj "+ order.getUser().getUsername() +","
                    + "\n\n Wlasnie skompletowalismy twoje zamówienie, czeka na odbiór. W sprawie dostarczenia" +
                    " zamówienie na konkretny adres prosze kontaktowac sie z biurem na nr 600-600-600" +
                    "\n\n Pozdrawiamy");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    or.save(order);
        return "redirect:../../ordered";
    }


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
