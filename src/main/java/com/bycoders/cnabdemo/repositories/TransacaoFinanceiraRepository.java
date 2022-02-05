package com.bycoders.cnabdemo.repositories;

import com.bycoders.cnabdemo.entities.TransacaoFinanceira;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author patrik
 */
public interface TransacaoFinanceiraRepository extends JpaRepository<TransacaoFinanceira, Long> {
    
	@Query(value = "SELECT t FROM TransacaoFinanceira t WHERE t.loja = :loja")
	List<TransacaoFinanceira> findByLoja(@Param("loja") String loja);
	
	@Query(value = "SELECT DISTINCT t.loja FROM TransacaoFinanceira t ORDER BY t.loja")
	List<String> findLojasDistinct();
	
}