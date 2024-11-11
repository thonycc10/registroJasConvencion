package com.convenjasapi.convenjasapi.dao;

import com.convenjasapi.convenjasapi.dto.ParticipantDto;
import com.convenjasapi.convenjasapi.entity.Barrio;
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

    @Query("select p.nombre from Participante p " +
            "where p.estaca.id = :idEstaca and p.barrio.id = :idBarrio and p.distrito.id = :idDistrito")
    List<String> getParticipanteByIds(Long idEstaca, Long idBarrio, Long idDistrito);

    @Query("select count(p.id) " +
            "from Participante p " +
            "where p.distrito.id = :distritoId and p.barrio.id = :barrioId " +
            "and (p.miembro = 'Miembro' or p.miembro = 'Converso') " +
            "group by p.distrito")
    Integer participantTotalByNoMembers(Long distritoId, Long barrioId);

    @Query("select count(p.id) " +
            "from Participante p " +
            "where p.distrito.id = :distritoId and p.barrio.id = :barrioId " +
            "and p.miembro = 'Invitado' " +
            "group by p.distrito")
    Integer participantTotalByMembers(Long distritoId, Long barrioId);
}
