package com.travel.Controller;


import com.travel.AtrractionsVO.AttractionsVO;
import com.travel.AtrractionsVO.LocationAttractionsResponse;
import com.travel.Service.AttractionService;
import com.travel.entity.Attractions;
import com.travel.entity.Products;
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


    /*
     * 获取景点数据
     * fetchAttractions
     * 请求参数：
     * attraction_id:String,
     *
     * 响应参数：
     * locations:[{
     *    loaction,
     *    attractions:[{
     *      attraction_id,
     *      name,
     *      description,
     *      image,
     *      },...]
     * },...],
     *
     */
    @PostMapping("/fetchAttractions")
    public List<LocationAttractionsResponse> fetchAttractions() {
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
                            attraction.getDescription()))
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

    /*
     * 获取单个景点的详细信息
     * fetchAttractionDetail
     * 请求参数：
     * attraction_id: String  // 景点ID,从attractionsLists组件中获取
     *
     * 响应参数：
     * {
     *   name: String,            // 景点名称
     *   created_at: String,     // 创建时间
     *   updated_at: String,      // 更新时间
     *   location: String,        // 所在地区
     *   image: String,            // 景点图片地址
     *   opening_hours: String,   // 开放时间
     *   transportation: String,  // 交通信息
     *   description: String,     // 景点描述
     *   relatedFigures: [{     // 相关名人信息数组
     *     person_id: String,     // 名人ID
     *     name: String,         // 名人姓名
     *     image: String,        // 名人图片地址
     *     message: String       // 名人介绍
     *   }],
     *   likes: Number           // 点赞数量
     * }
     */
    @PostMapping("/fetchAttractionDetail")
    public AttractionsVO fetchAttractionDetail(@RequestBody Map<String, Long> request) {

        Long attraction_id= request.get("attraction_id");
        log.info("根据id获取单个景点的详细信息: {}", attraction_id);
        return attractionService.fetchAttractionDetail(attraction_id);
    }
}
