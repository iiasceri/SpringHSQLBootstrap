package com.deloitte.mvc.controller;

import com.deloitte.mvc.model.User;
import com.deloitte.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegisterPage(@ModelAttribute("user") User user) {
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String takeRegisterValues(@ModelAttribute("user") User user,
                                     @RequestParam(value="confirmPassword") String confirmPassword,
                                     Model model) {

        String hash = "$2a$10$mL0Xwpe8NThYuToTCepO3u";
        user.setPassword(BCrypt.hashpw(user.getPassword(), hash));

        if (user.getPassword().equals(BCrypt.hashpw(confirmPassword, hash)))
            userService.add(user);
        else {
            model.addAttribute("error", "Passwords don't match!");
            return "register";
        }
        return "redirect:/todo/show-todos";
    }

    @RequestMapping(value = "/error", method = GET)
    public String loginErrorHandler(Model model) {
        model.addAttribute("error", "Login or Password are invalid");
        return "login";
    }

    @RequestMapping(value = "/errorRegister", method = GET)
    public String registerErrorHandler(Model model) {
        model.addAttribute("error", "Passwords don't match!");
        return "register";
    }

    @RequestMapping(value = "/logout", method = GET)
    public String logout() {
        return "redirect:/login";
    }
}