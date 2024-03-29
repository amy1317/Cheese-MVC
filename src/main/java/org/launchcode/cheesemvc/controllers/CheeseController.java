package org.launchcode.cheesemvc.controllers;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.AttributedString;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("cheese")
public class CheeseController{
    //added HashMap instead of ArrayList so we can add description so it has a key and value for cheese and description
    static HashMap<String, String> cheeses = new HashMap<>();
    //static ArrayList<String> cheeses = new ArrayList<>();

    //Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        //cheeses.add(cheeseName);
        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("title", "Delete Cheese");
        model.addAttribute("cheeses", cheeses);

        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String DeleteCheeseForm(@RequestParam ArrayList<String> cheeseName) {

        for (String cheese : cheeseName){
            cheeses.remove(cheese);
        }
            return "redirect:";

        }
    }



