package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Estaca;

import java.util.List;

public interface EstacaService {

    public List<Estaca> findAll();

    public  List<Estaca> findBarrioByEstaca(Long id);


}
