package com.travel.Service.impI;


import com.travel.Mapper.AttractionMapper;
import com.travel.Service.AttractionService;
import com.travel.entity.Attractions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AttractionServiceImpI  implements AttractionService {

    @Autowired
    private AttractionMapper attractionMapper;

    @Override
    public List<Attractions> find() {
        return attractionMapper.finds();
    }

    @Override
    public Attractions getById(Integer attractionId) {

        Attractions attractions=attractionMapper.getById(attractionId);


        return attractions;
    }
}
