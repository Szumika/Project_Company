package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {
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



    @ModelAttribute("orders")
    public List<Orders> orders(){
     List <Orders> orders = this.or.findAll();
    return orders;
}
    @ModelAttribute("groups1")
    public List<groups> groups(){
        List <groups> grp = this.gr.findAll();
        return grp;
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
