package com.project.vetfacade.controller;
import com.project.vetfacade.service.AuthenticationService;
import com.project.vetfacade.service.MailSenderService;
import com.project.vetfacade.service.RegistrationService;
import com.project.vetfacade.user.User;
import com.project.vetfacade.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        return registrationService.register(user);
    }

    @GetMapping("/activate")
    public String showConfirmationForm(@RequestParam("code") String activationCode, Model model) {
        return registrationService.activateUser(activationCode, model);
    }

    @PostMapping("/activate")
    public String processConfirmationForm(@ModelAttribute("user") User user) {
        registrationService.finishActivation(user);
        return "activation-success";
    }
}
