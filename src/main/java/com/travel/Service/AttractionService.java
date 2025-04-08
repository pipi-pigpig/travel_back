package com.travel.Service;

import com.travel.AtrractionsVO.AttractionsVO;
import com.travel.entity.Attractions;

import java.util.List;

public interface AttractionService {

    List<Attractions> find();

    Attractions getById(Integer attractionId);

    AttractionsVO fetchAttractionDetail(long attractionId);

    int handleLikes(long attractionId);

    void deleteScenery(long attractionId);
}
