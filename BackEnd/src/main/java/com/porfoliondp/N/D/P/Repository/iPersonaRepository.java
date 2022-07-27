
package com.porfoliondp.N.D.P.Repository;

import com.porfoliondp.N.D.P.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPersonaRepository extends JpaRepository<Persona, Long> {
    
}
