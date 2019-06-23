package com.convenjasapi.convenjasapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "participante")
public class Participante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String miembro; // verificar si es miembro
    private Integer telefono;
    @Column(name = "nombre_ref")
    private String nombreRef;
    @Column(name = "telefono_ref")
    private Integer telefonoRef;
    @Column(nullable=false, unique=false)
    private Integer documento;
    private char sexo;
    private String correo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    private Distrito distrito;

    public Estaca getEstaca() {
        return estaca;
    }

    public void setEstaca(Estaca estaca) {
        this.estaca = estaca;
    }

    @ManyToOne
    private Estaca estaca;

    @ManyToOne
    private Barrio barrio;

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

    public String getMiembro() {
        return miembro;
    }

    public void setMiembro(String miembro) {
        this.miembro = miembro;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getNombreRef() {
        return nombreRef;
    }

    public void setNombreRef(String nombreRef) {
        this.nombreRef = nombreRef;
    }

    public Integer getTelefonoRef() {
        return telefonoRef;
    }

    public void setTelefonoRef(Integer telefonoRef) {
        this.telefonoRef = telefonoRef;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @PrePersist // ayuda a crear automaticamente la fech actual de un registro
    public void prePersist() {
        fechaCreacion = new Date();
    }

    private static final long serialVersionUID = 1L;
}
