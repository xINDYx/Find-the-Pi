package com.indy.findthepi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
public class MainController {
    public int newcalc = 2 ;

    @GetMapping("/")
    public String main(Model model){
        return "main";
    }

    @GetMapping("/calc")
    public String calc(Model model){
        BigDecimal result = new BigDecimal(Math.PI);
        result = result.setScale(newcalc, RoundingMode.DOWN);
        model.addAttribute("newcalc", result);
        return "calc";
    }

    @PostMapping("/calc")
    public String calcAdd(@RequestParam String calc, Model model){
        newcalc = Integer.parseInt(calc);
        return "redirect:/calc";
    }
}
