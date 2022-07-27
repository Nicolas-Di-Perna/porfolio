
package com.porfoliondp.N.D.P.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String domicilio;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String fechaNac;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String edad;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String correo;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String telefono;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String user;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String img;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String sobreMi;

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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
