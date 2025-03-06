package com.travel.AtrractionsVO;


import com.travel.entity.Attractions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationAttractionsResponse {

    private String location;
    private List<Attractions> attractions;

}
