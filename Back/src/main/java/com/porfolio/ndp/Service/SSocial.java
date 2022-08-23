
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Social;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.porfolio.ndp.Repository.RSocial;
import java.util.Optional;
import javax.transaction.Transactional;



@Service
@Transactional
public class SSocial{
    @Autowired 
    RSocial rSocial;
    
   
  
    public List<Social> list (){
        return rSocial.findAll();
    }
    
    public Optional<Social> getOne(int id){
        return rSocial.findById(id);
    }
    
    public Optional<Social> getByNombreS(String nombreS) {
        return rSocial.findByNombreS(nombreS);
    }
    
    public void save (Social social) {
        rSocial.save(social);
    }
    
    public void delete(int id){
        rSocial.deleteById(id);
    }
    
     public boolean existsById(int id){
         return rSocial.existsById(id);
     }
    
    public boolean existByNombreS(String nombreS) {
        return rSocial.existsByNombreS(nombreS);
    }

    public boolean existById(int id) {
       return rSocial.existsById(id);
    }
}
