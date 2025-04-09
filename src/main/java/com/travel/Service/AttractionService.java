package com.travel.Service;

import com.travel.VO.AttractionsVO;
import com.travel.entity.Attractions;

import java.util.List;

public interface AttractionService {

    List<Attractions> find();

    Attractions getById(Integer attractionId);

    AttractionsVO fetchAttractionDetail(long attractionId);

    int handleLikes(long attractionId);

    void deleteScenery(long attractionId);

    int likeComment1(long attractionId);

}
