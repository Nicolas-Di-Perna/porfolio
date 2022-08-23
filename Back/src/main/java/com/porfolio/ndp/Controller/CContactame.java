
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoContactame;
import com.porfolio.ndp.Entity.Contactame;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SContactame;
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
@RequestMapping("/contactame")
@CrossOrigin(origins = "http://localhost:4200")
public class CContactame {
  @Autowired
  SContactame sContactame;  
     
    @GetMapping("/lista")
    public ResponseEntity<List<Contactame>> list (){
        List<Contactame> list = sContactame.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Contactame> getById(@PathVariable("id") int id){
        if(!sContactame.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Contactame contactame = sContactame.getOne(id).get();
        return new ResponseEntity(contactame, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoContactame dtocontactame){
        if(StringUtils.isBlank(dtocontactame.getNombre()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        
       
        Contactame contactame = new Contactame(dtocontactame.getNombre(),
                                                dtocontactame.getTelefono(),
                                                dtocontactame.getCorreo(),
                                                  dtocontactame.getMensaje());
        sContactame.save(contactame);

        return new ResponseEntity(new Mensaje("Mensaje agregado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoContactame dtocontactame){
        if(!sContactame.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sContactame.existByNombre(dtocontactame.getNombre())&& sContactame.getByNombre(dtocontactame.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Contactame contactame =sContactame.getOne(id).get();
        contactame.setNombre(dtocontactame.getNombre());
        contactame.setTelefono(dtocontactame.getTelefono());
        contactame.setCorreo(dtocontactame.getCorreo());
        contactame.setMensaje(dtocontactame.getMensaje());
        
        sContactame.save(contactame);
        return new ResponseEntity(new Mensaje("Mensaje actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sContactame.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sContactame.delete(id);
        
        return new ResponseEntity(new Mensaje("Mensaje borrado"), HttpStatus.OK);
    }
}
