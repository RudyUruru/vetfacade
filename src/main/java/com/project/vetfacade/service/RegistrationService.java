package com.project.vetfacade.service;

import com.project.vetfacade.user.Role;
import com.project.vetfacade.user.User;
import com.project.vetfacade.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    private final MailSenderService mailSender;

    public String register(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()){
            return "registration-failure";
        }
        user.setActivationCode(UUID.randomUUID().toString());
        String confirmationUrl = "http://45.141.79.132:8090/registration/activate?code=" + user.getActivationCode();
        String body = "Для активации аккаунта перейдите по ссылке: " + confirmationUrl;
        mailSender.send(user.getEmail(),
                "Код активации",
                body);
        userRepo.save(user);
        return "registration-success";
    }

    public String activateUser(String activationCode, Model model) {
        User user = userRepo.findByActivationCode(activationCode);
        if (user != null) {
            user.setActivationCode(null);
            model.addAttribute("user", user);
            return "password-form";
        } else {
            return "activation-failure";
        }
    }
    public void finishActivation(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
