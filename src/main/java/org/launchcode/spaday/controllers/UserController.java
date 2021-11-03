package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping(value="add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        // add form submission handling code here
        String password = user.getPassword();
        if (Objects.equals(verify, password)) {
            model.addAttribute("username", user.getUsername());
            return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords must match.");
            return "user/add";
        }
    }



}
