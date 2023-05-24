package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping ("/posts")
    @ResponseBody
    public String allPosts() {
        return "posts index page";
    }
    @GetMapping ("/posts/{id}")
    @ResponseBody
    public String individualPost() {
        return "View an individual post";
    }
    @GetMapping ("/posts/create")
    @ResponseBody
    public String createPosts() {
        return "View form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPosts() {
        return "Creating a new post";
    }

}
