
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Social;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RSocial extends JpaRepository<Social, Integer>{
    public Optional<Social> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}