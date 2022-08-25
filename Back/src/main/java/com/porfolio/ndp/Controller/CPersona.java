
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoPersona;
import com.porfolio.ndp.Entity.Persona;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SPersona;
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
@RequestMapping("/perso")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontporfoliondap.web.app")
public class CPersona {
    @Autowired
    SPersona sPersona;
  
     @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list (){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sPersona.existByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Persona ya registrada"), HttpStatus.BAD_REQUEST);
       
        Persona persona = new Persona(dtopersona.getNombre(),
                                        dtopersona.getApellido(),
                                        dtopersona.getDomicilio(),
                                        dtopersona.getFechaNac(),
                                        dtopersona.getTitulo(),
                                        dtopersona.getCorreo(),
                                        dtopersona.getTelefono(),
                                        dtopersona.getUsuario(),
                                        dtopersona.getPassword(),
                                        dtopersona.getSobreMi(),
                                        dtopersona.getImg());
            
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona){
        if(!sPersona.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
          if(sPersona.existByNombre(dtopersona.getNombre())&& sPersona.getByNombre(dtopersona.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona =sPersona.getOne(id).get();
                                persona.setNombre(dtopersona.getNombre());
                                persona.setApellido(dtopersona.getApellido());  
                                persona.setDomicilio(dtopersona.getDomicilio());
                                persona.setFechaNac(dtopersona.getFechaNac());
                                persona.setTitulo(dtopersona.getTitulo());
                                persona.setCorreo(dtopersona.getCorreo());
                                persona.setTelefono(dtopersona.getTelefono());
                                persona.setUsuario(dtopersona.getUsuario());
                                persona.setPassword(dtopersona.getPassword());
                                persona.setSobreMi(dtopersona.getSobreMi());
                                persona.setImg(dtopersona.getImg());

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPersona.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sPersona.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona borrada"), HttpStatus.OK);
    }
}
    
 