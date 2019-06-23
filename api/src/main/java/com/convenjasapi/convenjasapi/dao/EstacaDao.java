package com.convenjasapi.convenjasapi.dao;

import com.convenjasapi.convenjasapi.entity.Estaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstacaDao extends JpaRepository<Estaca, Long> {

    @Query("select e from Estaca e inner join fetch e.barrio where e.id =:id")
    List<Estaca> findByBarrioByEstacaWithEagerRelationships(@Param("id") Long id);
}
