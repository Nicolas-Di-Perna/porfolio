
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
     @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String link;
    @NotBlank
    private String img;
    
    //constructores

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String descripcion, String fecha, String link, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
        this.img = img;
    }
    
    // Getters Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
