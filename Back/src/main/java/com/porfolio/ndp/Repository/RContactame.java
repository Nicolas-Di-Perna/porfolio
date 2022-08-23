
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Contactame;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RContactame extends JpaRepository<Contactame, Integer>{
    public Optional<Contactame> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
