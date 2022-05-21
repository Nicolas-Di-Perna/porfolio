
package com.porfolio.nicolas.Interface;

import com.porfolio.nicolas.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Elliminar un objeto buscado por id
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);
}
