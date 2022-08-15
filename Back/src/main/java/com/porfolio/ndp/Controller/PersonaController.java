
package com.porfolio.ndp.Controller;

import com.porfolio.ndp.Entity.Persona;
import com.porfolio.ndp.Interface.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired iPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada.";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue borrada.";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("domicilio") String nuevoDomicilio,
                                @RequestParam("fechaNac") String nuevofechaNac,
                                @RequestParam("titulo") String nuevotitulo,
                                @RequestParam("correo") String nuevoCorreo,
                                @RequestParam("telefono") String nuevotelefono,
                                @RequestParam("usuario") String nuevoUsuario,
                                @RequestParam("password") String nuevoPassword,
                                @RequestParam("img") String nuevoImg,
                                @RequestParam("sobreMi") String nuevosobreMi){
        
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setDomicilio(nuevoDomicilio);
        persona.setFechaNac(nuevofechaNac);
        persona.setTitulo(nuevotitulo);
        persona.setCorreo(nuevoCorreo);
        persona.setTelefono(nuevotelefono);
        persona.setUsuario(nuevoUsuario);
        persona.setPassword(nuevoPassword);
        persona.setImg(nuevoImg);
        persona.setSobreMi(nuevosobreMi);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public  Persona findPersona() {
        return ipersonaService.findPersona((long)1);
    }
}

