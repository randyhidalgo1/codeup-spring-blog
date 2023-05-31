package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.AdRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class AdController {

    public User randomUser(UserRepository usersDao){
        List<User> allUsers = usersDao.findAll();
        int randomInt = new Random().nextInt(allUsers.size());
        return allUsers.get(randomInt);
    }
    private final AdRepository adsDao;

    private final UserRepository usersDao;
    public AdController(AdRepository adsDao, UserRepository usersDao){
        this.adsDao = adsDao;
        this.usersDao = usersDao;
    }


    @GetMapping("/ads")
    public String adIndex(Model model) {
        model.addAttribute("ads", adsDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String createAdForm(){
        return "ads/create";
    }
    @PostMapping("/ads/create")
    public String createAd(@RequestParam(name="title") String title, @RequestParam(name="description") String description){
        User user = randomUser(usersDao);
        Ad ad = new Ad(title, description, user);
        adsDao.save(ad);
        return "redirect:/ads";
    }
}