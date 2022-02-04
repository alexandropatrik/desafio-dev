package com.bycoders.cnabdemo.resource;

import java.io.File;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bycoders.cnabdemo.entities.ArquivoCnab;
import com.bycoders.cnabdemo.repositories.ArquivoCnabRepository;
import com.bycoders.cnabdemo.services.ArquivoService;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;
import com.bycoders.cnabdemo.utils.ResourceResponseUtil;

@RestController
@RequestMapping("/transacao")
public class TransacaoFinanceiraResource {

	@Autowired
	ArquivoCnabRepository arquivoCnabRepository;

	@Autowired
	TransacaoFinanceiraService transacaoFinanceiraService;
	
    @Autowired
    private ArquivoService fileStorageService;
	
    @PostMapping("/processar")
    @Transactional
    public ResponseEntity<ResourceResponseUtil> processarTransacao(@RequestParam("file") MultipartFile file) {
    	if (arquivoCnabRepository.findByNome(file.getOriginalFilename()).size() > 0) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResourceResponseUtil(HttpStatus.BAD_REQUEST, String.format("Arquivo com o nome %s já processado", file.getOriginalFilename()), null));
    	}

        String fileName = fileStorageService.storeFile(file);

        transacaoFinanceiraService.processar(fileName);
        arquivoCnabRepository.save(new ArquivoCnab(new File(fileName).getName()));
    	
    	return ResponseEntity.ok().build();
    }
	
}

