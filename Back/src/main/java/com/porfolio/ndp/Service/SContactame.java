
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Contactame;
import com.porfolio.ndp.Repository.RContactame;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContactame {
     @Autowired
    RContactame rContactame;
    
    public List<Contactame> list (){
        return rContactame.findAll();
    }
    
    public Optional<Contactame> getOne(int id){
        return rContactame.findById(id);
    }
    
    public Optional<Contactame> getByNombre(String nombre) {
        return rContactame.findByNombre(nombre);
    }
    
    public void save (Contactame contactame) {
        rContactame.save(contactame);
    }
    
    public void delete(int id){
        rContactame.deleteById(id);
    }
    
     public boolean existsById(int id){
         return rContactame.existsById(id);
     }
    
    public boolean existByNombre(String nombre) {
        return rContactame.existsByNombre(nombre);
    }

    public boolean existById(int id) {
       return rContactame.existsById(id);
    }
}

  