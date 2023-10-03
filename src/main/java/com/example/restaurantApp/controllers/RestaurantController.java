package com.example.restaurantApp.controllers;


import com.example.restaurantApp.common.entity.Restaurant;
import com.example.restaurantApp.common.model.ResponseBody;
import com.example.restaurantApp.common.model.SuggestionRequest;
import com.example.restaurantApp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/submit")
    public ResponseEntity<ResponseBody> submit(@RequestBody SuggestionRequest suggestionRequest) {
        return restaurantService.processSuggestion(suggestionRequest);
    }

    @GetMapping(value = "/randomSuggestion")
    public ResponseEntity<ResponseBody> randomSuggest() {
        return restaurantService.suggestRandom();
    }
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<Restaurant>>listAll() {
        return restaurantService.listAll();
    }
    @GetMapping(value = "/deleteAll")
    public ResponseEntity<ResponseBody> deleteAll() {
        return restaurantService.deleteAll();
    }
}
