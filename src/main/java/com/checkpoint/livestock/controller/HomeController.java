package com.checkpoint.livestock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView exibirHome() {
        return new ModelAndView("/home");
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }
}
