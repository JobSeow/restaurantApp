package com.example.restaurantApp.repository;

import com.example.restaurantApp.common.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByNameEqualsIgnoreCase(String name);
}
