package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.dao.DistritoDao;
import com.convenjasapi.convenjasapi.dto.ParticipantDto;
import com.convenjasapi.convenjasapi.entity.Barrio;
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

    @Autowired
    private BarrioService barrioService;

    @Autowired
    private ParticipanteService participanteService;

    @Override
    public int distritosById(Long distritoId, Long idBarrio, Integer isGuest) {
        int valor = 0;
        Integer totalMember = participanteService.participantTotalByIds(distritoId, idBarrio, 0);
        Integer totalGuest = participanteService.participantTotalByIds(distritoId, idBarrio, 1);
        Barrio barrio = barrioService.findByIdBarrio(idBarrio);

        if (totalMember == barrio.getMaxParticipate()
                || (totalGuest == barrio.getMaxInvitate() && isGuest == 1)) {
            valor = 1; // 1 es que se lleno
        }

        return valor; // no se lleno
    }

    @Override
    public Distrito findById(Long id) {
        return distritoDao.findById(id).orElse(null);
    }
}
