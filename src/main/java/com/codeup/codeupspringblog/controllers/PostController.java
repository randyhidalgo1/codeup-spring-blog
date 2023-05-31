package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeup.codeupspringblog.repositories.PostsRepository;

import java.util.List;

@Controller
public class PostController {

    private PostsRepository postsDao;

    public PostController(PostsRepository postsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/creator-of-posts")
    public String createForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitForm(@RequestParam(name="title") String title, @RequestParam(name="body") String content) {
        Post post = new Post(title, content);
        postsDao.save(post);
        return "redirect:/posts";
    }
}

















//package com.codeup.codeupspringblog.controllers;
//import repositories.PostsRepository;
//
//import com.codeup.codeupspringblog.models.Post;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class PostController {
//    private final PostsRepository postsDao;
//
//    public PostController(PostsRepository postsDao){
//        this.postsDao = postsDao;
//    }
//
//
//    @GetMapping("/posts")
//    public String listPosts(Model model) {
//        List<Post> posts = postsDao.findAll();
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }
//    @GetMapping("/posts/{id}")
//    public String showPost(@PathVariable Long id, Model model) {
//        Post post = postsDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
//        model.addAttribute("post", post);
//        return "posts/show";
//    }
//    @GetMapping("/creator-of-posts")
//    public String createPost(){
//        return "/posts/create";
//    }
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String content) {
//        Post post = new Post(title, content);
//        postsDao.save(post);
//        return "redirect:/posts";
//    }
//
//
//
//
//}
//
//
//
//
//
////@Controller
////public class PostController {
////    @GetMapping("/posts")
////    public String allPosts(Model model) {
////        List<Post> posts = new ArrayList<>();
////        Post post1 = new Post();
////        post1.setTitle("First Post");
////        post1.setBody("This is the first post.");
////        posts.add(post1);
////
////        Post post2 = new Post();
////        post2.setTitle("Second Post");
////        post2.setBody("This is the second post.");
////        posts.add(post2);
////
////        model.addAttribute("posts", posts);
////        return "posts/index";
////    }
////
////    @GetMapping("/posts/{id}")
////    public String individualPost(@PathVariable int id, Model model) {
////        Post post = new Post();
////        post.setTitle("Post " + id);
////        post.setBody("This is the post with id " + id + ".");
////        model.addAttribute("post", post);
////        return "posts/show";
////    }
////
////    @GetMapping("/posts/create")
////    public String createPosts() {
////        return "posts/create";
////    }
////
////    @PostMapping("/posts/create")
////    public String submitPosts() {
////        // Logic for creating a new post
////        return "redirect:/posts";
////    }
////}
//
//
