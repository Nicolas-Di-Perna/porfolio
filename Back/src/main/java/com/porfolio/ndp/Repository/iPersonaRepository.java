
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPersonaRepository extends JpaRepository<Persona, Long> {
    
}

