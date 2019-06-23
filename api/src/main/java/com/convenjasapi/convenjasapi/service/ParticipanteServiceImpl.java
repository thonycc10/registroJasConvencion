package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.controller.EstacaController;
import com.convenjasapi.convenjasapi.dao.DistritoDao;
import com.convenjasapi.convenjasapi.dao.ParticipanteDao;
import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

import static sun.security.krb5.Confounder.longValue;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    private final Logger log = LoggerFactory.getLogger(ParticipanteServiceImpl.class);


    @Autowired
    private ParticipanteDao participanteDao;

    @Autowired
    private DistritoService distritoService;

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
    public List<Distrito> listDistritosByIdEstaca(Long idEstaca) {
        List<Distrito> distritos = null;
        List<Distrito> distrito = new ArrayList();
        distritos = distritoService.findAll();
        log.info("Listar Participantes: ");
        for (Distrito a : distritos) {
            int cEntra = 0;
            int cMaxima = 0;
            boolean validar = true;
            for (Participante b : a.getParticipantes()) {
                if (b.getEstaca().getId().equals(idEstaca)) {
                    cMaxima++;
                }
            }
            if(cMaxima < 6 ) {
                 distrito.add(a);
            }
        }
        return distrito;
    }

    @Override
    public Participante saved(Participante participante) {
        return participanteDao.save(participante);
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
