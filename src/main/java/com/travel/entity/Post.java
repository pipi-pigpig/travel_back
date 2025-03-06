package com.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long post_id;        // post_id
    private Long user_id;        // user_id
    private String title;       // title
    private String message;     // message
    private LocalDateTime created_at ;     // created_at
    private LocalDateTime updated_at ;     // updated_at
    private long likes;         // likes
    private String post_partition; // post_partition

}
