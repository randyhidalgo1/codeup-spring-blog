//package com.codeup.codeupspringblog.controllers;
//
//import com.codeup.codeupspringblog.models.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import repositories.UserRepository;
//
//@Controller
//public class UserController {
//    private UserRepository userDao;
//
//    public UserController(UserRepository userDao) {
//        this.userDao = userDao;
//    }
//
//    @GetMapping("/register")
//    public String registration() {
//        return "/register";
//    }
//
//    public String registerUser(@RequestParam String username,
//                               @RequestParam String email,
//                               @RequestParam String password) {
//        User user = new User(username, email, password);
//        userDao.save(user);
//        return "redirect:/ads";
//    }
//
//}
