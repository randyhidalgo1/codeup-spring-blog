package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showGuessPage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        Random random = new Random();
        List<Integer> diceRolls = new ArrayList<>();
        int matchCount = 0;
        for (int i =0; i < 5; i++) {
            int diceRoll = random.nextInt(6) + 1;
            diceRolls.add(diceRoll);
            if (diceRoll == n) {
                matchCount++;
            }
        }

        model.addAttribute("diceRolls", diceRolls);
        model.addAttribute("userGuess", n);
        model.addAttribute("matchCount", matchCount);
        return "dice-results";
    }
}
