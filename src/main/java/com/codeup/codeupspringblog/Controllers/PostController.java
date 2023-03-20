package com.codeup.codeupspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping ("/posts")
    @ResponseBody
    public String allPosts(){
        return "These are all the posts endpoint";
    }

    @GetMapping ("/posts/{id}")
    @ResponseBody
    public String getPostById(@PathVariable String name){
        return "This is the post for " + name;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createAPostView(){
        return "This is the end point to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createAPost(){
        return "You created a post";
    }
}
