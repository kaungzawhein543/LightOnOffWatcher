package com.epc.LightOnOffWatcher.controller;

import com.epc.LightOnOffWatcher.CalculateTime;
import com.epc.LightOnOffWatcher.bean.GroupAndDate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class index {

    private boolean group = true;

    @GetMapping("/")
    public String indexRoute(Model m) {
        if(m.containsAttribute("times")) {
            m.addAttribute("times", m.getAttribute("times"));
        }
        m.addAttribute("inputData", new GroupAndDate());
        m.addAttribute("group", group);
        return "index";
    }

    @PostMapping(value="/getTime")
    public String getTime(@ModelAttribute GroupAndDate inputData, RedirectAttributes redirectAttributes){
        CalculateTime calculateTime = new CalculateTime();
        String[] timeArray =  calculateTime.calculate(Integer.parseInt(inputData.getDay()), inputData.getGroup());
        redirectAttributes.addFlashAttribute("times", timeArray);
        return "redirect:/";
    }

    @PostMapping("/changeValue")
    public String changeValue(Model m) {
        this.group = !group;
        m.addAttribute("group", group);
        return "redirect:/";
    }
}
