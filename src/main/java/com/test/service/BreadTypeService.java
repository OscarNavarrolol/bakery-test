package com.test.service;

import com.test.entity.BreadType;

import java.util.List;

public interface BreadTypeService {

    public BreadType saveBreadType(BreadType breadType);

    public List<BreadType> getAll();

    public BreadType getById(Long id);

    public BreadType updateBreadType(Long id, BreadType breadType);

    public void deleteBreadType(Long id);

}
