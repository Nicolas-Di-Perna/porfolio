
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio, Integer>{
    public Optional<Estudio> findByInstituto(String instituto);
    public boolean existsByInstituto(String instituto);
}
