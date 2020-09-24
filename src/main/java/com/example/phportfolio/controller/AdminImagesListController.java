package com.example.phportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/images")
public class AdminImagesListController {

    @GetMapping
    public String getAdminImagesListListPage(Model model) {
        model.addAttribute("simpleTitle", "Hello, dear user!");
        return "image";
    }
}
