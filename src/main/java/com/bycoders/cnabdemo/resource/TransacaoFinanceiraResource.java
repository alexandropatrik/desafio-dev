package com.bycoders.cnabdemo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bycoders.cnabdemo.utils.ResourceResponseUtil;

@RestController
@RequestMapping("/transacao")
public class TransacaoFinanceiraResource {

    @PostMapping("/processar")
    public ResponseEntity<ResourceResponseUtil> processarTransacao(@RequestParam("file") MultipartFile file) {

    	return ResponseEntity.noContent().build();
    }
	
}

