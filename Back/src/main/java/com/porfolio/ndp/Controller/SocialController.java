
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Entity.Social;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.porfolio.ndp.Interface.iSocialService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SocialController {
    @Autowired iSocialService isocialService;
    
    @GetMapping("/social/traer")
    public List<Social> getSocial() {
        return isocialService.getSocial();
    } 
    
    @PostMapping("/social/crear")
    public String createSocial(@RequestBody Social social) {
        isocialService.saveSocial(social);
        return "La red Social fue agregada.";
    }
    
     @DeleteMapping("/social/borrar/{id}")
    public String deleteSocial(@PathVariable Long id) {
        isocialService.deleteSocial(id);
        return "La red Social fue borrada.";
    }
    
      @PutMapping("social/editar/{id}")
    public Social editSocial(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("link") String nuevoLink,
                                @RequestParam("icono") String nuevoIcono){
        
        Social social = isocialService.findSocial(id);
        
        social.setNombre(nuevoNombre);
        social.setLink(nuevoLink);
        social.setIcono(nuevoIcono);
        
        isocialService.saveSocial(social);
        return social;
    }

    @GetMapping("/social/traer/red")
    public  Social findSocial() {
        return isocialService.findSocial((long)2);
    }
    
    
}
