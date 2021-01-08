package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.models.User;
import ru.job4j.forum.services.TopicService;

@Controller
public class RegControl {

    private final TopicService service;

    @Autowired
    public RegControl(TopicService service) {
        this.service = service;
    }

    @GetMapping("/reg")
    public String reg() {
        return "register";
    }

    @PostMapping("/reg")
    public String addNewUser(@ModelAttribute User user) {
        service.register(user);
        return "redirect:/login";
    }
}
