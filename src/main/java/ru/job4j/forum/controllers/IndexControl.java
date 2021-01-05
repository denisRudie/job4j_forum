package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.services.TopicService;

@Controller
public class IndexControl {

    private final TopicService service;

    @Autowired
    public IndexControl(TopicService service) {
        this.service = service;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("topics", service.getAllTopics());
        model.addAttribute(
                "username",
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        return "index";
    }
}
