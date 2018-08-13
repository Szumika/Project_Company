package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MenuContoller {
    @Autowired
    NewsRepository nr;
    @Autowired
    OrderRepository or;
    @Autowired
    IteamsRepository ir;
    @Autowired
    GroupsRepository gr;
    @Autowired
    EmployeeRepository er;
    @RequestMapping("/")
    public String start(){
        return "index";
    }
@RequestMapping("/news")
    public String news(){
    return "news";
}

@GetMapping("/items")
    public String items(){
    return "items";
}

@GetMapping("/communication")
    public String comm(){
    return "communication";
}

@GetMapping("/group")
public String groups(){
    return ("groups");
}

@GetMapping("/employee/{grpid}")
public String employee(@PathVariable long grpid , Model model){
    groups grp = this.gr.findOne(grpid);
    List<Employee> employees = this.er.findAllByGroup(grp);
    model.addAttribute("employees",employees);
    return "employ";
}

    @GetMapping("/order")
    public String addBookFormVali(@Valid Orders order, BindingResult result,Model m){
        m.addAttribute("order",new Orders());
        return "addFormValid";
    }

    @PostMapping("/order")
    public String addpostvali(@Valid Orders order, BindingResult result){
        if(result.hasErrors()){
            return "addFormValid";
        }
        order.setCreated(LocalDateTime.now());
//        order.setUser();
        this.or.save(order);
        return  "/items";
    }

@ModelAttribute("news")
    public List<news> newses(){
    return this.nr.FindNews();
}

@ModelAttribute("order")
    public List<Orders> orders(){
    return  this.or.findAll();
}
@ModelAttribute("items")
    public List<Item> item(){
    return  this.ir.findAll();
}
@ModelAttribute("groups")
    public List<groups> grp(){
    return this.gr.findAll();
}
@ModelAttribute("employee")
    public List<Employee> emplo(){
    return this.er.findAll();
}
}
