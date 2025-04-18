package com.travel.Service;

import com.travel.entity.FamousPeople;

import java.util.List;

public interface PeopleService {
    List<FamousPeople> find();


    List<FamousPeople> getById(Integer attractionId);

    List<FamousPeople> fetchFamousPeople();


    void deleteFamousPeople(long personId);
}
