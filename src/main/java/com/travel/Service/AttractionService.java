package com.travel.Service;

import com.travel.entity.Attractions;

import java.util.List;

public interface AttractionService {

    List<Attractions> find();

    Attractions getById(Integer attractionId);
}
