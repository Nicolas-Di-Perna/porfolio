
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Banner;
import com.porfolio.ndp.Repository.RBanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBanner {
    @Autowired
    RBanner rBanner;
    
      public List<Banner> list (){
        return rBanner.findAll();
    }
    
    public Optional<Banner> getOne(int id){
        return rBanner.findById(id);
    }
    
    public Optional<Banner> getByBanner(String img) {
        return rBanner.findByImg(img);
    }
    
    public void save (Banner banner) {
        rBanner.save(banner);
    }
    
    public void delete(int id){
        rBanner.deleteById(id);
    }
    
     public boolean existsById(int id){
         return rBanner.existsById(id);
     }
    
    public boolean existByImg(String img) {
        return rBanner.existsByImg(img);
    }

    public boolean existById(int id) {
       return rBanner.existsById(id);
    }
}


