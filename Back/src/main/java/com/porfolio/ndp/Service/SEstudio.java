
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Estudio;
import com.porfolio.ndp.Repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@Transactional
public class SEstudio {
    @Autowired
    REstudio rEstudio;
  public List<Estudio> list (){
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getByInstituto(String instituto) {
        return rEstudio.findByInstituto(instituto);
    }
    
    public void save (Estudio estu) {
        rEstudio.save(estu);
    }
    
    public void delete(int id){
        rEstudio.deleteById(id);
    }
    
     public boolean existsById(int id){
         return rEstudio.existsById(id);
     }
    
    public boolean existByInstituto(String instituto) {
        return rEstudio.existsByInstituto(instituto);
    }

    public boolean existById(int id) {
       return rEstudio.existsById(id);
    }
}
