package net.joostit.winchhunt.controllers;

import net.joostit.winchhunt.entities.User;
import net.joostit.winchhunt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SystemUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String showNewUserForm(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "userForm";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "redirect:/";
        }
    }
}