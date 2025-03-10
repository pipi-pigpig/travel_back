package com.travel.Controller;


import com.travel.Service.PeopleService;
import com.travel.entity.FamousPeople;
import com.travel.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}
