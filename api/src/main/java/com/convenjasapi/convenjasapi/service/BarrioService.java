package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Barrio;
import com.convenjasapi.convenjasapi.entity.Estaca;

import java.util.List;

public interface BarrioService {
    public List<Barrio> findAll();
    public  List<Barrio> findByEstaca(Long id);
}
