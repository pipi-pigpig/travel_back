package com.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long user_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String avtar;
    private LocalDateTime created_at ;
    private LocalDateTime updated_at ;
    private Integer now_address_id;
}
