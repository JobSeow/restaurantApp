package com.example.restaurantApp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="RESTAURANT")
public class Restaurant {

    private String name;

    @Id
    private Long id;


}
