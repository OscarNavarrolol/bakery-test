package com.test.service.impl;

import com.test.entity.BreadType;
import com.test.repository.BreadTypeRepository;
import com.test.service.BreadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreadTypeServiceImpl implements BreadTypeService {

    @Autowired
    private BreadTypeRepository breadTypeRepository;

    @Override
    public BreadType saveBreadType(BreadType breadType) {
        return breadTypeRepository.save(breadType);
    }

    @Override
    public List<BreadType> getAll() {
        return breadTypeRepository.findAll();
    }

    @Override
    public BreadType getById(Long id) {
        return breadTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BreadType updateBreadType(Long id, BreadType breadType) {
        BreadType oldBreadType = breadTypeRepository.findById(id).orElse(null);
        if(oldBreadType != null) {
            oldBreadType.setBreadName(breadType.getBreadName());
            oldBreadType.setPrice(breadType.getPrice());
            oldBreadType.setWeight(breadType.getWeight());
            oldBreadType.setProductionTime(breadType.getProductionTime());
            oldBreadType.setFlourId(breadType.getFlourId());
            return breadTypeRepository.save(oldBreadType);
        }
        return null;
    }

    @Override
    public void deleteBreadType(Long id) {
        breadTypeRepository.deleteById(id);
    }
}
