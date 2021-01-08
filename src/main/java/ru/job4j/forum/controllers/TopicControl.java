package ru.job4j.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.models.Message;
import ru.job4j.forum.models.Topic;
import ru.job4j.forum.services.TopicService;

@Controller
public class TopicControl {

    private final TopicService service;

    @Autowired
    public TopicControl(TopicService service) {
        this.service = service;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("topic", service.getTopicById(id));
        return "edit";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("username",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "edit";
    }

    @PostMapping("/save")
    public String saveTopic(@ModelAttribute Topic topic,
                            @ModelAttribute Message msg,
                            @RequestParam("username") String username) {
        Topic savedTopic = service.saveTopic(topic, username, msg);
        return "redirect:/" + savedTopic.getId();
    }

    @GetMapping("/{id}")
    public String topic(@PathVariable("id") int id, Model model) {
        Topic topic = service.getTopicById(id);
        model.addAttribute("topic", topic);
        model.addAttribute("username",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "topic";
    }

    @PostMapping("/create_message")
    public String createMessage(@RequestParam("topicId") int topicId,
                                @ModelAttribute Message msg,
                                @RequestParam("username") String username) {
        service.addMessage(msg, topicId, username);
        return "redirect:/" + topicId;
    }
}
