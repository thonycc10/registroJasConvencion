package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.controller.EstacaController;
import com.convenjasapi.convenjasapi.dao.BarrioDao;
import com.convenjasapi.convenjasapi.entity.Barrio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarrioServiceImpl implements BarrioService {
    private final Logger log = LoggerFactory.getLogger(EstacaController.class);

    @Autowired
    private BarrioDao barrioDao;
    @Override
    public List<Barrio> findAll() {
        return barrioDao.findAll();
    }

    @Override
    public List<Barrio> findByEstaca(Long id) {
        log.info("Valor de la estaca", id);
        return barrioDao.findByBarrioByEstacaWithEagerRelationships(id);
    }
}
