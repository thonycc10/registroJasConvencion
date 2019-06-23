package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Distrito;

import java.util.List;

public interface DistritoService {
    public List<Distrito> findAll();
    public int distritosById(Long id, Long idEstaca);
    public Distrito findById(Long id);
}
