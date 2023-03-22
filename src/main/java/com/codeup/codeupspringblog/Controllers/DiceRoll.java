package com.codeup.codeupspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class DiceRoll {

    private static int guessedNum(){
        Random ran = new Random();
        return  ran.nextInt(6) + 1;
    }

    @GetMapping("/dice-roll")
    public String showRollDice(){
        return "dice-roll";
    }

    @GetMapping("/dice-roll/{guess}")
    public String showDicePage(@PathVariable int guess, Model model)
    {
        int diceRoll = guessedNum();
        model.addAttribute("diceroll", diceRoll);
        model.addAttribute("guess", guess);
        String message = "Incorrect";

        if(diceRoll == guess){
            message = "correct";
        }

        model.addAttribute("message", message);
        return "dice-roll";
    }


}
