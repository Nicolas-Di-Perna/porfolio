
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkill extends JpaRepository<Skill, Integer>{
    public Optional<Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
