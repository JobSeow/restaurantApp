package com.example.restaurantApp.controllers;


import com.example.restaurantApp.entity.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/suggestion")
public class SuggestionController {

    @PostMapping(value = "/submit/{restaurantName}")
    public String submit(@PathVariable String restaurantName) {
        Restaurant student = new Restaurant();
        student.setName(restaurantName);
//        student.setAddress(studentId);

        return "Success";
    }

    @GetMapping(value = "/randomSuggest")
    public String randomSuggest() {
        //look thru DB, return the restaurant name

        return "Success";
    }
}
