package com.bycoders.cnabdemo.repositories;

import com.bycoders.cnabdemo.entities.ArquivoCnab;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author patrik
 */
public interface ArquivoCnabRepository extends JpaRepository<ArquivoCnab, Long> {
    
}
