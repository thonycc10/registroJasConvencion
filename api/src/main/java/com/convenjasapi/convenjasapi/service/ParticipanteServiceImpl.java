package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.dao.ParticipanteDao;
import com.convenjasapi.convenjasapi.dto.ParticipantDto;
import com.convenjasapi.convenjasapi.entity.Barrio;
import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    private final Logger log = LoggerFactory.getLogger(ParticipanteServiceImpl.class);


    @Autowired
    private ParticipanteDao participanteDao;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private BarrioService barrioService;

    @Override
    public List<Participante> findAll() {
        return participanteDao.findAll();
    }

    @Override
    public Participante findById(Integer documento, Long idEstaca) {
        Participante participante = null;
        participante = participanteDao.getParticipanteByDocumento(documento);
        if (participante == null ) {
            return participante;
        } else {
            return participante;
        }
    }

    @Override
    public List<Distrito> listDistritosByIdEstaca(Long idBarrio, Integer isGuest) {
        List<Distrito> distritos = null;
        List<Distrito> distrito = new ArrayList();
        distritos = distritoService.findAll();
        Barrio barrio = barrioService.findByIdBarrio(idBarrio);
        log.info("Listar Participantes: ");
        for (Distrito a : distritos) {
            int maxMember = (int) a.getParticipantes().stream()
                    .filter(x -> x.getBarrio().getId() == idBarrio && !Objects.equals(x.getMiembro(), "Invitado")).count();
            int maxInvitate = (int) a.getParticipantes().stream()
                    .filter(x -> x.getBarrio().getId() == idBarrio && Objects.equals(x.getMiembro(), "Invitado")).count();

            if (maxMember < barrio.getMaxParticipate() || (maxInvitate < barrio.getMaxInvitate() && isGuest == 1)) {
                distrito.add(a);
            }
        }
        return distrito;
    }

    @Override
    public Participante saved(Participante participante) {
        return participanteDao.save(participante);
    }

    @Override
    public List<String> participantsByIds(Long idEstaca, Long idBarrio, Long idDistrito) {
        return participanteDao.getParticipanteByIds(idEstaca, idBarrio, idDistrito);
    }

    @Override
    public Integer participantTotalByIds(Long distritoId, Long idBarrio, Integer isGuest) {
        Integer total = 0;
        if (isGuest == 1) {
            total = participanteDao.participantTotalByNoMembers(distritoId, idBarrio);
        } else {
            total = participanteDao.participantTotalByMembers(distritoId, idBarrio);
        }

        return total;
    }

    // ejemplo para llamar un recorrido
    private int indexOf(int valuee, List<Participante> array){
        int x = -1;
        for(Participante item : array){
            int i = item.getEstaca().getId().intValue();
            if (i == valuee) {
                x = item.getDistrito().getId().intValue();
                return x;
            }
        }
        return x;
    }
}
