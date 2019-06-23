package com.convenjasapi.convenjasapi.controller;

import com.convenjasapi.convenjasapi.entity.Estaca;
import com.convenjasapi.convenjasapi.service.EstacaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EstacaController {

    private final Logger log = LoggerFactory.getLogger(EstacaController.class);

    @Autowired
    private EstacaService estacaService;

    @GetMapping("/estaca")
    public List<Estaca> listEstaca () {
        return estacaService.findAll();
    }

    @GetMapping("/estaca/{id}")
    public List<Estaca> listBarriosByEstaca(@PathVariable Long id) {
        log.info("El valor de la busqueda estaca es : " + id.toString());
        return estacaService.findBarrioByEstaca(id);
    }
}
