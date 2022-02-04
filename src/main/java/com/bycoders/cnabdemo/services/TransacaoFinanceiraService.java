package com.bycoders.cnabdemo.services;

import com.bycoders.cnabdemo.dto.TransacaoFinanceiraDTO;
import com.bycoders.cnabdemo.repositories.TransacaoFinanceiraRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author patrik
 * 
 * Executa o processamento do arquivo CNAB, considerando as configurações
 * já realizadas no DTO
 * Também cria a entidade para persistência e invoca o repository para 
 * executar o insert
 * 
 */
@Service
public class TransacaoFinanceiraService {
    
	@Autowired
	TransacaoFinanceiraRepository transacaoFinanceiraRepository;
	
	/**
	 * Processa um arquivo CNAB e persiste os dados no banco de dados
	 * @param fileName - Arquivo (incluindo Path) que será processado
	 * @throws Dispara um RuntimeException caso não seja possível parsear o arquivo
	 */
    public void processar(String fileName) {
        ArrayList<TransacaoFinanceiraDTO> transacoes = new ArrayList<>();
        try {
            try ( final FileInputStream fisTargetFile = new FileInputStream(new File(fileName)) ) {
                List<String> linesStr = IOUtils.readLines(fisTargetFile, StandardCharsets.UTF_8);
                if (linesStr != null) {
                    linesStr
                        .stream()
                        .map(TransacaoFinanceiraDTO::new)
                        .forEachOrdered(edi -> transacoes.add((TransacaoFinanceiraDTO) edi.readLine()) );
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format("Erro ao processar o arquivo. \nDetalhes: %s ", ex.getLocalizedMessage()));
        }
        transacoes.stream().forEach(t -> {
        	transacaoFinanceiraRepository.save(t.toEntity());
        });
    }
    
}
