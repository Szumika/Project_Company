package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
@GetMapping("/PanelAdmin")
    public String admins(){
    return "admin/admin";
}


}
