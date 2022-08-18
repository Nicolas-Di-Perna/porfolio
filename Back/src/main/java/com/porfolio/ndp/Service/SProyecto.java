
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Proyecto;
import com.porfolio.ndp.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SProyecto {
  @Autowired
  RProyecto rProyecto;   
  
  public List<Proyecto> list (){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre) {
        return rProyecto.findByNombre(nombre);
    }
    
    public void save (Proyecto proyec) {
        rProyecto.save(proyec);
    }
    
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
     public boolean existsById(int id){
         return rProyecto.existsById(id);
     }
    
    public boolean existByNombre(String nombre) {
        return rProyecto.existsByNombre(nombre);
    }

    public boolean existById(int id) {
       return rProyecto.existsById(id);
    }
}

