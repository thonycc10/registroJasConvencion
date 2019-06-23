package com.convenjasapi.convenjasapi.dao;

import com.convenjasapi.convenjasapi.entity.Barrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarrioDao extends JpaRepository<Barrio, Long> {
    // select rol from Rol rol where rol.id =:id
   // "select usuario from Usuario usuario left join fetch usuario.rols where usuario.username =:username"
    @Query("select barrio from Barrio barrio left join fetch barrio.estaca where barrio.estaca.id =:id")
    List<Barrio> findByBarrioByEstacaWithEagerRelationships(@Param("id") Long id);


}
