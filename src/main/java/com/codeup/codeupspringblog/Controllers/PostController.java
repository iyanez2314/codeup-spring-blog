package com.codeup.codeupspringblog.Controllers;

import com.codeup.codeupspringblog.Services.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("post", new Post());
       return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createAPost(@ModelAttribute Post post){
        User user = userDao.findById(1L).get();
        post.setUser(user);
        emailService.prepareAndSend(post);
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String showEditPostView(@PathVariable("id") Long id, Model model) {
        Post editedPost = postDao.findById(id).get();
        model.addAttribute("post", editedPost);
        return "posts/edit";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post, @PathVariable Long id) {
            Post editedPost = postDao.findById(id).get();
            editedPost.setTitle(post.getTitle());
            editedPost.setBody(post.getBody());
            postDao.save(editedPost);
            return "redirect:/posts";
    }


//    @PostMapping("posts/{id}/edit")
//    public String editPost(@ModelAttribute Post post, @PathVariable long id){
//        User user = Users.randomUser(usersDao);
//        post.setUser(user);
//        post.setId(id);
//        postsDao.save(post);
//        return "redirect:/posts/" + id +"/find";
//    }

}
