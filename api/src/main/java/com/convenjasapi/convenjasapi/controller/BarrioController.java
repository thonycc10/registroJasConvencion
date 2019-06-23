package com.convenjasapi.convenjasapi.controller;


import com.convenjasapi.convenjasapi.entity.Barrio;
import com.convenjasapi.convenjasapi.service.BarrioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BarrioController {

    private final Logger log = LoggerFactory.getLogger(BarrioController.class);

    @Autowired
    private BarrioService barrioService;

    @GetMapping("/barrio")
    public List<Barrio> listBarrio() {
        return barrioService.findAll();
    }

    @GetMapping("/barrio/ByEstaca/{id}")
    public List<Barrio> listBarriosByEstaca(@PathVariable Long id) {
        log.info("El valor de la busqueda estaca es : " + id.toString());
       return barrioService.findByEstaca(id);
    }
}
