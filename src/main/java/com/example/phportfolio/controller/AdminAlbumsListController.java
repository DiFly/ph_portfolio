package com.example.phportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/albums")
public class AdminAlbumsListController {

    @GetMapping
    public String getAdminAlbumsListPage(Model model) {
        model.addAttribute("simpleTitle", "Hello, dear user!");
        return "album";
    }
}
