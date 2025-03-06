package com.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attractions {


    private Integer attraction_id;
    private String name;
    private String message;
    private String image;
    private String opening_hours;
    private String transportation;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String keyword;
    private Integer likes;
    private String location;


    public Attractions(int attraction_id, String name, String image, String message) {
        this.attraction_id = attraction_id;
        this.name = name;
        this.image = image;
        this.message = message;
    }
}
