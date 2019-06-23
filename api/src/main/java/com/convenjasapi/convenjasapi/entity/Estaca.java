package com.convenjasapi.convenjasapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estaca")
public class Estaca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "estaca")
    @JsonIgnore
    private Set<Barrio> barrio = new HashSet<>();

    @OneToMany(mappedBy = "estaca")
    @JsonIgnore
    private Set<Participante> participantes = new HashSet<>();

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Barrio> getBarrio() {
        return barrio;
    }

    public void setBarrio(Set<Barrio> barrio) {
        this.barrio = barrio;
    }

    private static final long serialVersionUID = 1L;
}
