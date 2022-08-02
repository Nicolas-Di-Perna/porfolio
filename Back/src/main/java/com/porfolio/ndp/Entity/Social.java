
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
public class Social implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String icono;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String link;
    
     @NotNull
    @Size(min = 1, max = 50, message = "Longuitud no valida.")
    private String idPersona;
    
}
