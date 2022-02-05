package com.bycoders.cnabdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.dto.ListaTransacaoDTO;
import com.bycoders.cnabdemo.exceptions.CnabdemoGenericException;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;

@SpringBootTest(classes = CnabDemoApplication.class)
class TransacaoFinanceiraServiceTest {

	@Autowired
	TransacaoFinanceiraService transacaoFinanceiraService;

	@Test
	void testExecute() {
		assertEquals(Boolean.TRUE, transacaoFinanceiraService.processar("src/test/resources/CNAB.txt"));
	}

	@Test
	void testInvalidFileExecute() {
		CnabdemoGenericException thrown = Assertions.assertThrows(CnabdemoGenericException.class, () -> {
			transacaoFinanceiraService.processar("src/test/resources/xCNAB.txt");
		});

	}
	
	@Test
	void testFindTransacoes() {
		 ListaTransacaoDTO dto = transacaoFinanceiraService.findTransacoes("BAR DO JOÃO");
		 assertEquals(Boolean.FALSE, dto == null);
	}
	
	@Test
	void testFindLoja() {
		 List<String> lojas = transacaoFinanceiraService.findLojas();
		 assertEquals(Boolean.FALSE, lojas == null);
	}
}
