package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String fechaNac;
    @NotBlank
    private String titulo;
    @NotBlank
    private String correo;
    @NotBlank
    private String telefono;
    @NotBlank
    private String usuario;
    @NotBlank
    private String password;
    @NotBlank
    private String img;
    @NotBlank
    private String sobreMi;
 //constructores

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String domicilio, String fechaNac, String titulo, String correo, String telefono, String usuario, String password, String img, String sobreMi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.titulo = titulo;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.img = img;
        this.sobreMi = sobreMi;
    }
    // Getters Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }
    
}
