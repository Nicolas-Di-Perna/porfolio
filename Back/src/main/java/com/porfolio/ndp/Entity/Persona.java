
package com.porfolio.ndp.Entity;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona implements Serializable {
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
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String correo;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String telefono;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String usuario;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String img;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String sobreMi;
    
}
