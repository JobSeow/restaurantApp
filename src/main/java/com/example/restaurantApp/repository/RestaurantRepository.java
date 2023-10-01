package com.example.restaurantApp.repository;

import com.example.restaurantApp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByNameLike(String name);
}
