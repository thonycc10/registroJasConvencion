package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ParticipanteService {
    public List<Participante> findAll();
    public Participante findById(Integer documento, Long idEstaca);

    public List<Distrito> listDistritosByIdEstaca(Long idEstaca);

    public Participante saved(Participante participante);
}
