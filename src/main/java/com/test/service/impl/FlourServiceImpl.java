package com.test.service.impl;

import com.test.entity.Flour;
import com.test.repository.FlourRepository;
import com.test.service.FlourService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlourServiceImpl implements FlourService {

    @Autowired
    private FlourRepository flourRepository;

    @Override
    public Flour saveFlour(Flour flour) {
        return flourRepository.save(flour);
    }

    @Override
    public List<Flour> getAll() {
        return flourRepository.findAll();
    }

    @Override
    public Flour getById(Long id) {
        return null;
    }

    @Override
    public Flour updateFlour(Long id, Flour flour) {
        return null;
    }

    @Override
    public void deleteFlour(Long id) {

    }
}
