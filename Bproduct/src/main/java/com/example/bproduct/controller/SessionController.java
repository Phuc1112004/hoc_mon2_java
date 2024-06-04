package com.example.bproduct.controller;


import com.example.bproduct.model.User;
import com.example.bproduct.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SessionController {
    // call instance of model
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam ("password") String password,
                        HttpSession session){

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)){  // có pass == pass nhap vao
            session.setAttribute("user", optionalUser.get());
            return "redirect:/welcome";
        }
        else {
            model.addAttribute("error", "Invalid username or password");
        }
        return "index";
    }
    @GetMapping("/welcome")
    public String welcome(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("username",user.getUsername());
            return "result";
        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();  // destroy session             hủy toàn bộ session
        return "redirect:/";
    }
}
