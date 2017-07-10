package com.sokoldevpro.blog.web;

import com.sokoldevpro.blog.domain.model.LoginForm;
import com.sokoldevpro.blog.service.LoginService;
import com.sokoldevpro.blog.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/users/login")
    public String showLoginForm(LoginForm loginForm) {
        return "users/login";
    }


    @RequestMapping(value = "/users/login", method = POST)
    public String showLoginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }

        if (!loginService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            notificationService.addErrorMessage("Invalid login!");
            return "users/login";
        }

        notificationService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}