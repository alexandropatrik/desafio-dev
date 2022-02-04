package com.bycoders.cnabdemo.repositories;

import com.bycoders.cnabdemo.entities.ArquivoCnab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author patrik
 */
public interface ArquivoCnabRepository extends JpaRepository<ArquivoCnab, Long> {
    
	List<ArquivoCnab> findByNome(String nome);
	
}
