package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.dao.DistritoDao;
import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoDao distritoDao;

    @Override
    public List<Distrito> findAll() {
        return distritoDao.findAll();
    }

    @Override
    public int distritosById(Long id, Long idEstaca) {
        int valor = 0;
       Distrito distrito = distritoDao.findById(id).orElse(null);
        int cMaxima = 0;
        for (Participante b : distrito.getParticipantes()) {
            if (b.getEstaca().getId().equals(idEstaca)) {
                cMaxima++;
            } else {
                return valor; // no se lleno
            }
            if(cMaxima >= 6) {
                valor = 1; // 1 es que se lleno
                return valor;
            }
        }
        return valor; // no se lleno
    }

    @Override
    public Distrito findById(Long id) {
        return distritoDao.findById(id).orElse(null);
    }
}
