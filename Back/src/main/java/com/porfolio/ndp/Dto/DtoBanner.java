
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoBanner {
    @NotBlank
    private String img;
     @NotBlank
    private String nombre;
    
      //constructores
  public DtoBanner() {
    }
 
    public DtoBanner(String img, String nombre) {
        this.img = img;
        this.nombre = nombre;
    }

  // Getters Setters

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
