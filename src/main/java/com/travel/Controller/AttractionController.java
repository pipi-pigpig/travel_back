package com.travel.Controller;


import com.travel.AtrractionsVO.LocationAttractionsResponse;
import com.travel.Service.AttractionService;
import com.travel.entity.Attractions;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/Attractions")
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping("/getAttractions")
    public List<LocationAttractionsResponse> getAttractions() {
        List<LocationAttractionsResponse> locationsList = new ArrayList<>();

        // 假设 attractionService.find() 获取所有景点数据
        List<Attractions> allAttractions = attractionService.find(); // 获取所有景点

        // 按城市分组景点
        Map<String, List<Attractions>> locationsMap = allAttractions.stream()
                .collect(Collectors.groupingBy(Attractions::getLocation));

        // 构建响应
        for (Map.Entry<String, List<Attractions>> entry : locationsMap.entrySet()) {
            String locationName = entry.getKey();
            List<Attractions> attractions = entry.getValue();

            // 映射到所需的 JSON 格式
            List<Attractions> attractionResponses = attractions.stream()
                    .map(attraction -> new Attractions( // 使用新类名
                            attraction.getAttraction_id(), // 改为 attraction_id
                            attraction.getName(),
                            attraction.getImage(), // 改为 image
                            attraction.getMessage()))
                    .collect(Collectors.toList());

            locationsList.add(new LocationAttractionsResponse(locationName, attractionResponses));
        }

        return locationsList;
    }



    @GetMapping("/{attraction_id}")
    public Result<Attractions> showAttraction(@PathVariable Integer attraction_id) {

       Attractions attractions= attractionService.getById(attraction_id);


        return Result.success(attractions);
    }

}
