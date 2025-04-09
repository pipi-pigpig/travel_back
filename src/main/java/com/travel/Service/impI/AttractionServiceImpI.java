package com.travel.Service.impI;


import com.travel.VO.AttractionsVO;
import com.travel.Mapper.AttractionMapper;
import com.travel.Service.AttractionService;
import com.travel.entity.Attractions;
import com.travel.entity.FamousPeople;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Override
    public AttractionsVO fetchAttractionDetail(long attractionId) {

        Attractions attractions=attractionMapper.getById(attractionId);

        AttractionsVO attractionsVO=new AttractionsVO();
        BeanUtils.copyProperties(attractions,attractionsVO);

        List<FamousPeople> famousPeople=attractionMapper.getFamousPeopleById(attractionId);
        attractionsVO.setRelatedFigures(famousPeople);
        return attractionsVO;
    }

    @Override
    public int handleLikes(long attractionId) {
        return attractionMapper.getLikes(attractionId);
    }

    @Override
    public void deleteScenery(long attractionId) {
         attractionMapper.deleteById(attractionId);
    }

    @Override
    public int likeComment1(long attractionId) {
        attractionMapper.updateLikes(attractionId);
        return attractionMapper.getLikes(attractionId);
    }
}
