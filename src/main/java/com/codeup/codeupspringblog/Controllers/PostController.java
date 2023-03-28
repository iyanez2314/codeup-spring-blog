package com.codeup.codeupspringblog.Controllers;

import com.codeup.codeupspringblog.Services.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepository postDao;

    private final EmailService emailService;

    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping ("/posts")
    public String allPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping ("/posts/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model){
//        This will allow us to get the id from the post we are looking for
        Post post = postDao.getById(id);
//        I will get the user from the queried post
        User user = post.getUser();
//        Then I get the email that is associated with said user
        String email = user.getEmail();
//        then pass information to the model (view)
        model.addAttribute("post", post);
        model.addAttribute("userEmail", email);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String createAPostView(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = (User) ((UsernamePasswordAuthenticationToken) authentication).getPrincipal();
        if(loggedInUser != null){
            model.addAttribute("post", new Post());
            return "posts/create";
        } else {
            return "error";
        }


    }

    @PostMapping("/posts/create")
    public String createAPost(@ModelAttribute Post post){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User loggedInUser = (User) ((UsernamePasswordAuthenticationToken) authentication).getPrincipal();
            System.out.println(loggedInUser.getUsername());
            Post newPost = new Post(post.getTitle(), post.getBody());
            newPost.setUser(loggedInUser);
            postDao.save(newPost);
            return "redirect:/posts";
        } else {
            return "error";
        }
    }


    @GetMapping("/posts/{id}/edit")
    public String showEditPostView(@PathVariable("id") Long id, Model model){
        Post post = postDao.getById(id);
        if(post != null){
            model.addAttribute("post", post);
            return "posts/edit";
        } else {
            return "Post not found";
        }
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@RequestParam("title") String title, @RequestParam("body") String body, @PathVariable("id") Long id){
        Post post = postDao.getById(id);
        if(post != null){
            post.setTitle(title);
            post.setBody(body);
            postDao.save(post);
            return "redirect:/posts";
        } else {
            return "error";
        }
    }
}
