
package com.porfolio.ndp.Interface;

import com.porfolio.ndp.Entity.Social;
import java.util.List;

public interface iSocialService {
     //traer lista persona//
    public List<Social> getSocial();
    
    //guardar un objeto de tipo persona//
    public void saveSocial(Social social);
    
    //eliminar objeto buscado por id//
    public void deleteSocial(Long id);
    
    //buscar persona por id//
    public Social findPersona(Long id);

    public Social findSocial(Long id);
       
}