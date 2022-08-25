
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Dto.DtoBanner;
import com.porfolio.ndp.Entity.Banner;
import com.porfolio.ndp.Security.Controller.Mensaje;
import com.porfolio.ndp.Service.SBanner;
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
@RequestMapping("/banner")

@CrossOrigin(origins = "https://frontporfoliondap.web.app")


public class CBanner {
  @Autowired
  SBanner sBanner;  
     
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list (){
        List<Banner> list = sBanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id){
        if(!sBanner.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoBanner dtobanner){
        if(StringUtils.isBlank(dtobanner.getNombre()))
            return new ResponseEntity(new Mensaje("Falta el nombre"),HttpStatus.BAD_REQUEST);
        if(sBanner.existByNombre(dtobanner.getNombre()))
            return new ResponseEntity(new Mensaje("Banner ya registrado"), HttpStatus.BAD_REQUEST);
       
        Banner banner = new Banner(dtobanner.getNombre(),
                                                  dtobanner.getImg());
        sBanner.save(banner);

        return new ResponseEntity(new Mensaje("Banner agregado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoBanner dtobanner){
        if(!sBanner.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        if(sBanner.existByNombre(dtobanner.getNombre())&& sBanner.getByNombre(dtobanner.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Campo nombre, oligatorio"), HttpStatus.BAD_REQUEST);
        
        Banner banner =sBanner.getOne(id).get();
        banner.setNombre(dtobanner.getNombre());
        banner.setImg(dtobanner.getImg());
        
        sBanner.save(banner);
        return new ResponseEntity(new Mensaje("Banner actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sBanner.existById(id))
                return new ResponseEntity(new Mensaje("ID erroneo"), HttpStatus.BAD_REQUEST);
        
        sBanner.delete(id);
        
        return new ResponseEntity(new Mensaje("Banner borrado"), HttpStatus.OK);
    }
}
