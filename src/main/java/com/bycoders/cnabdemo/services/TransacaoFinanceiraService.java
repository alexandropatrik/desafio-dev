package com.bycoders.cnabdemo.services;

import com.bycoders.cnabdemo.dto.TransacaoFinanceiraDTO;
import com.bycoders.cnabdemo.repositories.TransacaoFinanceiraRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    
	@Autowired
	TransacaoFinanceiraRepository transacaoFinanceiraRepository;
	
    @PostMapping("/processar")
    public void processar() {
        
        ArrayList<TransacaoFinanceiraDTO> transacoes = new ArrayList<>();
        
        try {
            try ( final FileInputStream fisTargetFile = new FileInputStream(new File("src/main/resources/example/CNAB.txt")) ) {
                List<String> linesStr = IOUtils.readLines(fisTargetFile, StandardCharsets.UTF_8);
                if (linesStr != null) {
                    linesStr
                        .stream()
                        .map(TransacaoFinanceiraDTO::new)
                        .forEachOrdered(edi -> transacoes.add((TransacaoFinanceiraDTO) edi.readLine()) );
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TransacaoFinanceiraService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        transacoes.stream().forEach(t -> {
        	transacaoFinanceiraRepository.save(t.toEntity());
        });
        
    }
    
     /*public List<ProdutoDTO> execute() {
        ArrayList<ProdutoDTO> produtos = new ArrayList<>();
        try {
            try ( final FileInputStream fisTargetFile = new FileInputStream(new File("src/main/resources/sample_data.txt")) ) {
                List<String> linesStr = IOUtils.readLines(fisTargetFile, StandardCharsets.UTF_8);
                if (linesStr != null) {
                    linesStr
                        .stream()
                        .map(ProdutoDTO::new)
                        .forEachOrdered(edi -> produtos.add((ProdutoDTO) edi.readLine()) );
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    */
}
