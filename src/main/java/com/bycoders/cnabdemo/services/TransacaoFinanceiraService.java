package com.bycoders.cnabdemo.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author patrik
 */
@RestController
@RequestMapping("/transacao")
public class TransacaoFinanceiraService {
    
    @PostMapping("/processar")
    public void processar() {
        
    }
    
}
