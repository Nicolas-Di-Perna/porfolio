
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoSocial;
import com.porfolio.ndp.Entity.Social;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SSocial;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/social")
@CrossOrigin(origins = "http://localhost:4200")
public class CSocial {
    @Autowired
    SSocial sSocial;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Social>> list (){
        List<Social> list = sSocial.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Social> getById(@PathVariable("id") int id){
        if(!sSocial.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Social social = sSocial.getOne(id).get();
        return new ResponseEntity(social, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSocial dtosocial){
        if(StringUtils.isBlank(dtosocial.getNombreS()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sSocial.existByNombreS(dtosocial.getNombreS()))
            return new ResponseEntity(new Mensaje("Red Social ya registrada"), HttpStatus.BAD_REQUEST);
       
        Social social = new Social(dtosocial.getNombreS(),
                                                  dtosocial.getIcono(),
                                                  dtosocial.getLink()
                                                  );
        sSocial.save(social);

        return new ResponseEntity(new Mensaje("Red Social agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSocial dtosocial){
        if(!sSocial.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sSocial.existByNombreS(dtosocial.getNombreS())&& sSocial.getByNombreS(dtosocial.getNombreS()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Social social =sSocial.getOne(id).get();
        social.setNombreS(dtosocial.getNombreS());
        social.setIcono(dtosocial.getIcono());
        social.setLink((dtosocial.getLink()));
        
        sSocial.save(social);
        return new ResponseEntity(new Mensaje("Red Social actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSocial.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sSocial.delete(id);
        
        return new ResponseEntity(new Mensaje("Red Social borrada"), HttpStatus.OK);
    }
}
