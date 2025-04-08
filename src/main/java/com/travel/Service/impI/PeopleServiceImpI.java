package com.travel.Service.impI;

import com.travel.Mapper.PeopleMapper;
import com.travel.Service.PeopleService;
import com.travel.entity.FamousPeople;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PeopleServiceImpI implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<FamousPeople> find() {
        return peopleMapper.finds();
    }

    @Override
    public List<FamousPeople> getById(Integer attractionId) {


        return peopleMapper.getById(attractionId);
    }

    @Override
    public List<FamousPeople> fetchFamousPeople() {
        return peopleMapper.getPeoples();
    }

    @Override
    public void deleteFamousPeople(long personId) {
        peopleMapper.deleteFamousPeople(personId);
    }


}
