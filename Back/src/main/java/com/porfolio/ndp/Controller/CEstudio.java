
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoEstudio;
import com.porfolio.ndp.Entity.Estudio;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SEstudio;
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
@RequestMapping("/estu")
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    
    @Autowired
    SEstudio sEstudio;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list (){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }    
    
 @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoestu){
        if(StringUtils.isBlank(dtoestu.getInstituto()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sEstudio.existByInstituto(dtoestu.getInstituto()))
            return new ResponseEntity(new Mensaje("Estudio ya registrada"), HttpStatus.BAD_REQUEST);
       
        Estudio estudio = new Estudio(dtoestu.getInstituto(),
                                                  dtoestu.getNombre(),
                                                  dtoestu.getFechaInicio(),
                                                  dtoestu.getFechaFin(),
                                                  dtoestu.getTitulo(),
                                                  dtoestu.getImg());
        sEstudio.save(estudio);

        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoestu){
        if(!sEstudio.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sEstudio.existByInstituto(dtoestu.getInstituto())&& sEstudio.getByInstituto(dtoestu.getInstituto()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio =sEstudio.getOne(id).get();
            estudio.setNombre(dtoestu.getNombre());
            estudio.setInstituto((dtoestu.getInstituto()));
            estudio.setFechaInicio(dtoestu.getFechaInicio());
            estudio.setFechaFin(dtoestu.getFechaFin());
            estudio.setTitulo(dtoestu.getTitulo());
            estudio.setImg(dtoestu.getImg());
        
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEstudio.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sEstudio.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudio borrada"), HttpStatus.OK);
    }
}