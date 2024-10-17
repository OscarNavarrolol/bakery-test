package com.test.service;

import com.test.entity.BreadType;

public interface BreadTypeService {

    public BreadType saveBreadType(BreadType breadType);

    public BreadType getAll();

    public BreadType getById(Long id);

    public BreadType updateBreadType(Long id, BreadType breadType);

    public void deleteBreadType(Long id);

}
