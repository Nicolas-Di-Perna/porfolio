
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoSkill;
import com.porfolio.ndp.Entity.Skill;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SSkill;
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
@RequestMapping("/skill")

@CrossOrigin(origins = "https://frontporfoliondap.web.app")
public class CSkill {
    @Autowired
    SSkill sSkill;
    
 @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list (){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sSkill.existByNombre(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("Skill ya registrada"), HttpStatus.BAD_REQUEST);
       
        Skill skill = new Skill(dtoskill.getNombre(),
                                                  dtoskill.getPorcentaje(),
                                                  dtoskill.getIcono()
                                                  );
        sSkill.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoskill){
        if(!sSkill.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sSkill.existByNombre(dtoskill.getNombre())&& sSkill.getByNombre(dtoskill.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill =sSkill.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setPorcentaje((dtoskill.getPorcentaje()));
        skill.setIcono(dtoskill.getIcono());
        
        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkill.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill borrada"), HttpStatus.OK);
    }
}
