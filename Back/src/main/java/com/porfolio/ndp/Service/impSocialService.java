
package com.porfolio.ndp.Service;

import com.porfolio.ndp.Entity.Social;
import com.porfolio.ndp.Interface.iSocialService;
import com.porfolio.ndp.Repository.iSocialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class impSocialService implements iSocialService{
    @Autowired iSocialRepository isocialRepository;
    
     @Override
    public List<Social> getSocial() {
        List<Social> social = isocialRepository.findAll();
        return social;
    }

    @Override
    public void saveSocial(Social social) {
        isocialRepository.save(social);
    }

    @Override
    public void deleteSocial(Long id) {
        isocialRepository.deleteById(id);
    }

    @Override
    public Social findSocial(Long id) {
       Social social = isocialRepository.findById(id).orElse(null);
       return social;
    }

    @Override
    public Social findPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
    }
