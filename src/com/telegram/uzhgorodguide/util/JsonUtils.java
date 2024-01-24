package com.telegram.uzhgorodguide.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static <T> List<T> loadFromJson(String filePath, Class<T> clazz, String arrayName) {
        try (FileReader fileReader = new FileReader(filePath)) {
            JsonArray jsonArray = JsonParser.parseReader(fileReader).getAsJsonObject().getAsJsonArray(arrayName);

            return StreamSupport.stream(jsonArray.spliterator(), false)
                    .map(jsonElement -> gson.fromJson(jsonElement, clazz))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
