package com.test.service;

import com.test.entity.BreadType;
import com.test.entity.Flour;

import java.util.List;

public interface FlourService {

    public Flour saveFlour(Flour flour);

    public List<Flour> getAll();

    public Flour getById(Long id);

    public Flour updateFlour(Long id, Flour flour);

    public void deleteFlour(Long id);

}
