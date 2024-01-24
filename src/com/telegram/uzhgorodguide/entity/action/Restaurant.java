package com.telegram.uzhgorodguide.entity.action;

import com.telegram.uzhgorodguide.util.JsonUtils;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private String description;
    private String reviews;

    public Restaurant(String name, String address, String description, String reviews) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.reviews = reviews;
    }

    public String getReviews() {
        return reviews;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public static List<Restaurant> loadRestaurantsFromJson(String filePath) {
        return JsonUtils.loadFromJson(filePath, Restaurant.class, "restaurant");
    }
}