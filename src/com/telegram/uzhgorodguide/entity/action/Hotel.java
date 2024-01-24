package com.telegram.uzhgorodguide.entity.action;

import com.telegram.uzhgorodguide.util.JsonUtils;
import java.util.List;

public class Hotel {
    private String reviews;
    private String name;
    private String address;
    private String information;

    public Hotel(String reviews, String name, String address, String information) {
        this.name = name;
        this.address = address;
        this.information = information;
        this.reviews = reviews;
    }

    public String getInformation() {
        return information;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getReviews() {
        return reviews;
    }

    public static List<Hotel> loadHotelsFromJson(String filePath) {
        return JsonUtils.loadFromJson(filePath, Hotel.class, "hotels");
    }
}