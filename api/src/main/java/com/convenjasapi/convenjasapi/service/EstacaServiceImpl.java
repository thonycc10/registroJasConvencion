package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.dao.EstacaDao;
import com.convenjasapi.convenjasapi.entity.Estaca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacaServiceImpl implements EstacaService{

    @Autowired
    private EstacaDao estacaDao;

    @Override
    public List<Estaca> findAll() {
        return estacaDao.findAll();
    }

    @Override
    public List<Estaca> findBarrioByEstaca(Long id) {
        return estacaDao.findByBarrioByEstacaWithEagerRelationships(id);
    }
}
