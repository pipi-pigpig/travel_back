package com.travel.Controller;


import com.travel.Service.PeopleService;
import com.travel.entity.FamousPeople;
import com.travel.entity.Products;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/FamousPeople")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/getFamousPeoples")
    public List<FamousPeople> getUser(){


        return peopleService.find();
    }

    @GetMapping("/{attraction_id}")
    public List<FamousPeople> getFamousPeopleById(@PathVariable Integer attraction_id){

       List<FamousPeople> famousPeople= peopleService.getById(attraction_id);

        return famousPeople;
    }
    /*
     * 获取名人列表
     * fetchFamousPeople
     * 请求参数：
     *
     * 响应参数：
     * famousPeople[{
     *  id: 名人ID
     *  name: 名人名称
     * },...]
     *
     */
    @PostMapping("/fetchFamousPeople")
    public List<FamousPeople> fetchFamousPeople() {
        log.info("获取名人列表: ");
        return peopleService.fetchFamousPeople();
    }

    /*
     * 删除名人信息
     *deleteFamousPeople
     * 请求参数：
     * person_id: number
     * 响应参数：
     * 无
     */
    @PostMapping("/deleteFamousPeople")
    public  String deleteFamousPeople(@RequestBody Map<String, Object> request) {

        try {
            long person_id = ((Number) request.get("person_id")).longValue();

            log.info("根据id删除名人信息: {}", person_id);
            peopleService.deleteFamousPeople(person_id);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }

    }
}
