package com.telegram.uzhgorodguide.entity.action;

import com.telegram.uzhgorodguide.util.JsonUtils;
import java.util.List;

public class PlacesOfInterest {
    private String name;
    private String address;
    private String description;
    private Category category;

    public PlacesOfInterest(String name, String address, String description, Category category) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public static List<PlacesOfInterest> loadPlacesFromJson(String filePath) {
        return JsonUtils.loadFromJson(filePath, PlacesOfInterest.class, "places");
    }

    public enum Category{
        Музей,
        Замок,
        Галерея,
        Театр,
        Архітектура,
        Природа
    }
}