
package com.porfolio.ndp.Repository;

import com.porfolio.ndp.Entity.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iSocialRepository extends JpaRepository<Social, Long> {
    
}
