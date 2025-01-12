package com.epc.LightOnOffWatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {

    @GetMapping("/")
    public String indexRoute() {
        return "index";
    }
}
