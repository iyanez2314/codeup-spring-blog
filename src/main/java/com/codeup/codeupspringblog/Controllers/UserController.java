package com.codeup.codeupspringblog.Controllers;

import com.codeup.codeupspringblog.models.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserRepository userDao;
//    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
//        this.passwordEncoder = passwordEncoder;
    }


    // Without form model binding
//    @GetMapping("/sign-up")
//    public String showSignUpForm(){
//        return "users/sign-up";
//    }

    // Without Form Model Binding
//    @PostMapping("/sign-up")
//    public String saveUser(@RequestParam(name = "username") String username, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password){
//        String hash = passwordEncoder.encode(password); // hashing password
//        User newUser = new User(username, email, hash);
//        userDao.save(newUser);
//        return "redirect:/login";
//    }
















    // With form model binding
    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

<<<<<<< Updated upstream
//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user){
////        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/login";
//    }
=======
    // With form model binding
        @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword()); // hashing password
        User newUser = new User(user.getUsername(), user.getEmail(), hash);
        userDao.save(newUser);
        return "redirect:/login";
    }
>>>>>>> Stashed changes

}
