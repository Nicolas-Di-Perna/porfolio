
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoProyecto;
import com.porfolio.ndp.Entity.Proyecto;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SProyecto;
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
@RequestMapping("/proyecto")

@CrossOrigin(origins = "https://frontporfoliondap.web.app")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
  @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list (){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproyec){
        if(StringUtils.isBlank(dtoproyec.getNombre()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sProyecto.existByNombre(dtoproyec.getNombre()))
            return new ResponseEntity(new Mensaje("Proyecto ya registrada"), HttpStatus.BAD_REQUEST);
       
        Proyecto proyecto = new Proyecto(dtoproyec.getNombre(),
                                                  dtoproyec.getDescripcion(),
                                                  dtoproyec.getFecha(),
                                                  dtoproyec.getLink(),
                                                  dtoproyec.getImg());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproyec){
        if(!sProyecto.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existByNombre(dtoproyec.getNombre())&& sProyecto.getByNombre(dtoproyec.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto =sProyecto.getOne(id).get();
        proyecto.setNombre(dtoproyec.getNombre());
        proyecto.setDescripcion((dtoproyec.getDescripcion()));
        proyecto.setFecha(dtoproyec.getFecha());
        proyecto.setLink(dtoproyec.getLink());
        proyecto.setImg(dtoproyec.getImg());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto borrada"), HttpStatus.OK);
    }
}
