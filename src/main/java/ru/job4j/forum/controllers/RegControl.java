package ru.job4j.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegControl {

    @GetMapping("/reg")
    public String reg() {
        return "register";
    }
}
