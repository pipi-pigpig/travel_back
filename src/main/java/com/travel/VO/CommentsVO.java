package com.travel.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsVO {

    List<Comments_UsernameVO> comments_username=new ArrayList<>();
    List<Long> userComments=new ArrayList<>();
}
