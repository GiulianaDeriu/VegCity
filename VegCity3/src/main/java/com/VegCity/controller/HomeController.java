package com.VegCity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VegCity.model.User;

@Controller
public class HomeController {

    @GetMapping("/registrazione")
    public String registrazione(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registrazione";
    }

    @RequestMapping("/login")
    public String login() {
        return "registrazione";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession sessione) {
        sessione.invalidate();
        return "home";
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
