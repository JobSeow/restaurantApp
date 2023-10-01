package com.example.restaurantApp.services;

import com.example.restaurantApp.entity.Restaurant;
import com.example.restaurantApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public String processSuggestion(String name){
        boolean duplicate = isDuplicate(name);
        if (duplicate){
            return "Restaurant Already Exist";
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurantRepository.save(restaurant);
        return restaurant.getName();
    }

    public boolean isDuplicate(String name){
        List<Restaurant> existingList =   restaurantRepository.findAllByNameLike(name);
        if (!existingList.isEmpty()){
            return true;
        }
        return false;
    }
    public String suggestRandom(){
        List<Restaurant> existingList =  restaurantRepository.findAll();
        Random randomizer = new Random();
        Restaurant randomRestaurant =  existingList.get(randomizer.nextInt(existingList.size()));
        return randomRestaurant.getName();
    }


}

