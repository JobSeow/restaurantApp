package com.example.restaurantApp.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseBody {
    public String successMessage;
    public String errorMessage;
    public List<Object> data;
}
