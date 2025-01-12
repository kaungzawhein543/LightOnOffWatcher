package com.epc.LightOnOffWatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class index {

    private boolean group = true;

    @GetMapping("/")
    public String indexRoute(Model m) {
        m.addAttribute("group", group);
        return "index";
    }

    @PostMapping("/changeValue")
    public String changeValue(Model m) {
        this.group = !group;
        m.addAttribute("group", group);
        return "redirect:/";
    }
}
