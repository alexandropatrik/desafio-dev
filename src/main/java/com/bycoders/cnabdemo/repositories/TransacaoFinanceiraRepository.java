package com.bycoders.cnabdemo.repositories;

import com.bycoders.cnabdemo.entities.TransacaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author patrik
 */
public interface TransacaoFinanceiraRepository extends JpaRepository<TransacaoFinanceira, Long> {
    
}