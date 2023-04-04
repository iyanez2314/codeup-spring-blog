package com.codeup.codeupspringblog.Controllers;

import com.codeup.codeupspringblog.Services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping("/")
    public String welcome(){
        return "home";
    }
}
