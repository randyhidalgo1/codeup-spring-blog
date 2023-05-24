package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class CoffeeController {
    @GetMapping("/coffee")
    public String coffeePage() {
        return "Coffee";

    }
    @PostMapping("/coffee")
    public String newlettersignup(@RequestParam (name="email") String email, Model model){
    model.addAttribute("email", email);
        return "coffee";
    }
    @GetMapping("/coffee/{roast}")
    public String favRoast(@PathVariable String roast, Model model) {
        model.addAttribute("roast", roast);
        return "coffee";
    }

}




//
//    @GetMapping("/roll-dice {dice}")
//    public String RollDice(@PathVariable String dice, Model model) {
//        model.addAttribute("dice", dice);
//        return "dice";
//    }
