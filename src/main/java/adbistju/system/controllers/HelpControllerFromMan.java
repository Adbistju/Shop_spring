package adbistju.system.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HelpControllerFromMan {

    @GetMapping
    public String helpUser() {
        return "help.html";
    }

    @GetMapping("help/admin")
    public String helpAdmin() {
        return "helpAdmin.html";
    }

}
