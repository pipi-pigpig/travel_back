package com.travel.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments_UsernameVO {
    private Long post_comment_id;
    private String username;
    private String content;
    private Integer likes;
    private String avatar;
}
