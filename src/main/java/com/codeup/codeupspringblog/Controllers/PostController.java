package com.codeup.codeupspringblog.Controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping ("/posts")
    public String allPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping ("/posts/{id}")
    public String getPostById(@PathVariable("id") String id, Model model){
        Post newPost = new Post("an amazing title", "This is an amazing post that I have made yay");
        model.addAttribute("post", newPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createAPostView(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createAPost(@RequestParam("title") String name, @RequestParam("body") String body){
        Post post = new Post(name, body);
        postDao.save(post);
        return "redirect:/posts";
    }
}
