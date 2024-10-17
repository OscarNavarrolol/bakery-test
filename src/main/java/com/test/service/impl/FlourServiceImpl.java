package com.test.service.impl;

import com.test.entity.Flour;
import com.test.repository.FlourRepository;
import com.test.service.FlourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return flourRepository.findById(id).orElse(null);
    }

    @Override
    public Flour updateFlour(Long id, Flour flour) {
        Flour oldFlour = flourRepository.findById(id).orElse(null);
        if(oldFlour != null) {
            oldFlour.setFlourName(flour.getFlourName());
            oldFlour.setUnit(flour.getUnit());
            oldFlour.setQuantity(flour.getQuantity());
            return flourRepository.save(oldFlour);
        }
        return null;
    }

    @Override
    public void deleteFlour(Long id) {
        flourRepository.deleteById(id);
    }
}
