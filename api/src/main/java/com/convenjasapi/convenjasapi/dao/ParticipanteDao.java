package com.convenjasapi.convenjasapi.dao;

import com.convenjasapi.convenjasapi.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipanteDao extends JpaRepository<Participante, Long> {

    @Query("select p from Participante p where p.documento =:documento")
    Participante getParticipanteByDocumento(@Param("documento") Integer documento);

    @Query("select p from Participante p where p.estaca.id =:idEstaca")
    List<Participante> getParticipanteByIdEstaca(@Param("idEstaca") Long idEstaca);



}
