package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Distrito;

import java.util.List;

public interface DistritoService {
    public List<Distrito> findAll();
    int distritosById(Long id, Long idBarrio, Integer distritosById);
    public Distrito findById(Long id);
}
