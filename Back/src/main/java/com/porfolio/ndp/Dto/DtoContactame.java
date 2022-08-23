
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoContactame {
    @NotBlank
    private String nombre;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @NotBlank
    private String mensaje;
    
      //constructores

    public DtoContactame() {
    }

    public DtoContactame(String nombre, String telefono, String correo, String mensaje) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.mensaje = mensaje;
    }
  

  // Getters Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
