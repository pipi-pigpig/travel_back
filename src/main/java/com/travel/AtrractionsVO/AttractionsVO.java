package com.travel.AtrractionsVO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.travel.entity.FamousPeople;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttractionsVO {

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created_at;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updated_at;
    private String location;
    private String image;
    private String opening_hours;
    private String transportation;
    private String description;
    private Integer likes;

    List<FamousPeople> relatedFigures=new ArrayList<>();

}
