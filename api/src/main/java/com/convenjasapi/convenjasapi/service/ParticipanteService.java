package com.convenjasapi.convenjasapi.service;

import com.convenjasapi.convenjasapi.dto.ParticipantDto;
import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ParticipanteService {
    public List<Participante> findAll();
    public Participante findById(Integer documento, Long idEstaca);

    public List<Distrito> listDistritosByIdEstaca(Long idEstaca, Integer isGuest);

    public Participante saved(Participante participante);

    List<String> participantsByIds(Long idEstaca, Long idBarrio, Long idDistrito);

    Integer participantTotalByIds(Long distritoId, Long idBarrio, Integer isGuest);
}
