package com.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamousPeople {

    private Integer person_id;
    private String name;
    private String message;
    private UUID image;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
}
