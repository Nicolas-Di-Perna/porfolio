
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSocial {

     @NotBlank
    private String nombreS;
     @NotBlank
    private String icono;
     @NotBlank
    private String link;
     
     //constructores

    public DtoSocial() {
    }

    public DtoSocial(String nombreS, String icono, String link) {
       
        this.nombreS = nombreS;
        this.icono = icono;
        this.link = link;
    }
     // Getters Setters

 

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

     
}
