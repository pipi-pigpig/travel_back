package com.travel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDTO {
    private long post_id;        // user_id
    private String title;       // title
    private String message;
}
