package com.convenjasapi.convenjasapi.controller;

import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.service.DistritoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DistritoController {

    private final Logger log = LoggerFactory.getLogger(DistritoController.class);

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distrito")
    public List<Distrito> listDistrtio() {
        return distritoService.findAll();
    }

    @GetMapping("/distrito/{id}/{idEstaca}")
    public ResponseEntity<?> distritoById(@PathVariable Long id, @PathVariable Long idEstaca){
        int valor = 0;
        Map<String, Object> response = new HashMap<>();
        valor = distritoService.distritosById(id, idEstaca);
        if (valor == 1) {
            response.put("status", "LLENO");
        } else {
            response.put("status", "");
        }
        response.put("distritoId", id);
        response.put("estacaId", idEstaca);
        return new ResponseEntity<Map<String, Object> >(response, HttpStatus.OK);
    }

}
