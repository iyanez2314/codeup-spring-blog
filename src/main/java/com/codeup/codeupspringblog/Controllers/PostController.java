package com.codeup.codeupspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping ("/posts")
    public String allPosts(Model model){
        List<Post> posts = new ArrayList<>();
        Post newPost1 = new Post("amazing title", "amazing body of text");
        Post newPost2 = new Post("ANOTHER ONE", "ANOTHER BODY");
        posts.add(newPost1);
        posts.add(newPost2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping ("/posts/{id}")
    public String getPostById(@PathVariable("id") String id, Model model){
        Post newPost = new Post("an amazing title", "This is an amazing post that I have made yay");
        model.addAttribute("post", newPost);
        return "posts/show";
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
