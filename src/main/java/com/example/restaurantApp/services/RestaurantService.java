package com.example.restaurantApp.services;

import com.example.restaurantApp.common.entity.Restaurant;
import com.example.restaurantApp.common.model.ResponseBody;
import com.example.restaurantApp.common.model.SuggestionRequest;
import com.example.restaurantApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public ResponseEntity<ResponseBody> processSuggestion(SuggestionRequest request){
        ResponseBody responseBody = null;
        try{
            if (null==request.getName()||request.getName().isEmpty()){
                responseBody = ResponseBody.builder().errorMessage("Nothing Submitted").build();
                return new ResponseEntity<>( responseBody,HttpStatus.OK);
            }
            boolean duplicate = isDuplicate(request.getName());
            if (duplicate){
                responseBody = ResponseBody.builder().errorMessage("Restaurant Already Exist").build();
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }

            Restaurant restaurant = new Restaurant();
            restaurant.setName(request.getName());
            restaurantRepository.save(restaurant);
            responseBody = ResponseBody.builder().successMessage(restaurant.getName()).build();
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch(Exception e){
            responseBody = ResponseBody.builder().errorMessage("Something Wrong with the Server").build();
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }

    private boolean isDuplicate(String name){
        List<Restaurant> existingList =  restaurantRepository.findAllByNameEqualsIgnoreCase(name);
        if (!existingList.isEmpty()){
            return true;
        }
        return false;
    }

    public ResponseEntity<ResponseBody>  suggestRandom(){
        ResponseBody responseBody = null;
        try{
            List<Restaurant> existingList =  restaurantRepository.findAll();
            if (existingList.isEmpty()){
                responseBody = ResponseBody.builder().errorMessage(  "No Restaurants submitted").build();
                return new ResponseEntity<>(
                        responseBody,
                        HttpStatus.OK);
            }
            Random randomizer = new Random();
            Restaurant randomRestaurant =  existingList.get(randomizer.nextInt(existingList.size()));
            responseBody = ResponseBody.builder().successMessage(  randomRestaurant.getName()).build();
            return new ResponseEntity<>(
                    responseBody,
                    HttpStatus.OK);
        } catch(Exception e){
            responseBody = ResponseBody.builder().errorMessage("Something Wrong with the Server").build();
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }

    }


    public ResponseEntity<List<Restaurant>> listAll() {
        List<Restaurant> existingList =  restaurantRepository.findAll();
        return new ResponseEntity<>(
                existingList,
                HttpStatus.OK);
    }

    public ResponseEntity<ResponseBody> deleteAll() {
        restaurantRepository.deleteAll();
       ResponseBody responseBody = ResponseBody.builder().successMessage("Records Deleted").build();
        return new ResponseEntity<>(
                responseBody,
                HttpStatus.OK);
    }
}

