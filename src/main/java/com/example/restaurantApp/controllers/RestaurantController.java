package com.example.restaurantApp.controllers;


import com.example.restaurantApp.entity.Restaurant;
import com.example.restaurantApp.repository.RestaurantRepository;
import com.example.restaurantApp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/submit/{restaurantName}")
    public String submit(@PathVariable String restaurantName) {
        //test
        return restaurantService.processSuggestion(restaurantName);
    }

    @GetMapping(value = "/randomSuggestion")
    public String randomSuggest() {
        //look thru DB, return the restaurant name
        return restaurantService.suggestRandom();
    }
}
