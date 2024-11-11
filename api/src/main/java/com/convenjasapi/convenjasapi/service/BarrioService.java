package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Barrio;

import java.util.List;
import java.util.Optional;

public interface BarrioService {
    public List<Barrio> findAll();
    public  List<Barrio> findByEstaca(Long id);

    Barrio findByIdBarrio(Long idBarrio);
}
