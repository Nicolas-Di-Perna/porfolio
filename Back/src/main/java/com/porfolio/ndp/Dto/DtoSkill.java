
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkill {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String icono;
    
    //constructores

    public DtoSkill() {
    }

    public DtoSkill(String nombre, int porcentaje, String icono) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.icono = icono;
    }
     // Getters Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
}
