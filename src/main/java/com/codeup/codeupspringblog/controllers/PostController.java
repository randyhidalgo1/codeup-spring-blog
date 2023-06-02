package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Comment;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostsRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class PostController {

    private PostsRepository postsDao;
    private UserRepository usersDao;
    private CommentRepository commentsDao;
    private EmailService emailService;

    public PostController(PostsRepository postsDao, UserRepository usersDao, CommentRepository commentsDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.commentsDao = commentsDao;
        this.emailService = emailService;

    }
    @GetMapping("posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String submitEditForm(@PathVariable long id, @ModelAttribute Post updatedPost) {
        Post existingPost = postsDao.findById(id);
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBody(updatedPost.getBody());
        postsDao.save(existingPost);
        return "redirect:/posts";
    }
    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts = postsDao.findAll();
        Collections.reverse(posts);
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("/post-creator")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String submitForm(@ModelAttribute Post post) {
        User user = usersDao.findUserById(1L);
        post.setUser(user);
        postsDao.save(post);
        emailService.prepareAndSend(post, "New Post Created", "A new post has been created", "myinfo@onpointplus.com");
        return "redirect:/posts";
    }
    @PostMapping("/posts/comment")
    public String submitComment(@RequestParam(name = "content") String content, @RequestParam(name = "postId") long postId) {
        Post post = postsDao.findById(postId);
        User user = usersDao.findUserById(1L);
        Comment comment = new Comment(content, post, user);
        commentsDao.save(comment);
        return "redirect:/posts";
    }
    public PostsRepository getPostsDao() {
        return postsDao;
    }
    public void setPostsDao(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }
    public UserRepository getUsersDao() {
        return usersDao;
    }
    public void setUsersDao(UserRepository usersDao) {
        this.usersDao = usersDao;
    }
    public CommentRepository getCommentsDao() {
        return commentsDao;
    }
    public void setCommentsDao(CommentRepository commentsDao) {
        this.commentsDao = commentsDao;
    }

    public EmailService getEmailService() {
        return emailService;
    }
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}