
package com.porfoliondp.N.D.P.Interface;

import com.porfoliondp.N.D.P.Entity.Persona;
import java.util.List;


public interface iPersonaService {
    //traer lista persona//
    public List <Persona> getPersona();
    
    //guardar un objeto de tipo persona//
    public void savePersona(Persona persona);
    
    //eliminar objeto buscado por id//
    public void deletePersona(Long id);
    
    //buscar persona por id//
    public Persona findPersona(Long id);
       
}
