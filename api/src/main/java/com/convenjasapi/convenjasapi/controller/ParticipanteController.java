package com.convenjasapi.convenjasapi.controller;

import com.convenjasapi.convenjasapi.entity.Distrito;
import com.convenjasapi.convenjasapi.entity.Participante;
import com.convenjasapi.convenjasapi.service.DistritoService;
import com.convenjasapi.convenjasapi.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/participante")
    public List<Participante> allParticipante() {
        return participanteService.findAll();
    }

    @GetMapping("/participante/{documento}/{idEstaca}")
    public ResponseEntity<?> sendDistritoValidarPaciente(@PathVariable Integer documento, @PathVariable Long idEstaca) {
        Participante participante = null;
        Map<String, Object> response = new HashMap<>();
        try {
            participante = participanteService.findById(documento, idEstaca);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (participante == null) {
            response.put("mensaje", "NO EXISTE");
            List<Distrito> distrit = null;
            distrit = participanteService.listDistritosByIdEstaca(idEstaca);
            response.put("distritos", distrit);
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.OK);
        }
        return  new ResponseEntity<Participante>(participante, HttpStatus.OK);
    }

    @PostMapping("/participante")
    public ResponseEntity<?> savedParticipante(@RequestBody Participante participante){
        Participante participante1 = null;
        Map<String, Object> response = new HashMap<>();
        int verificar = 0;
        verificar = distritoService.distritosById(participante.getDistrito().getId(), participante.getEstaca().getId());
        try {
            if (verificar == 0) {
                participante1 = participanteService.saved(participante);
            } else {
                Distrito distrito = distritoService.findById(participante.getDistrito().getId());
                response.put("mensaje", "El cupo para el distrito ".concat(distrito.getNombre()).concat(" ya se ha llenado. Seleeccione otro distrito "));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Exito");
        response.put("cliente", participante1);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
