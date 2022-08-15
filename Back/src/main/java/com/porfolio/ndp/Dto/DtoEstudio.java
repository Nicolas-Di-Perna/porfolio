
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEstudio {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String instituto;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String titulo;
    @NotBlank
    private String img;
    
     //constructores

    public DtoEstudio() {
    }

    public DtoEstudio(String nombre, String instituto, String fechaInicio, String fechaFin, String titulo, String img) {
        this.nombre = nombre;
        this.instituto = instituto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.img = img;
    }
    
    // Getters Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
