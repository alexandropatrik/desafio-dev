package com.bycoders.cnabdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.exceptions.CnabdemoGenericException;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CnabDemoApplication.class)
public class TransacaoFinanceiraServiceTest {

	@Autowired
	TransacaoFinanceiraService transacaoFinanceiraService;
	
	@Test
    void testExecute() {
		transacaoFinanceiraService.processar("src/test/resources/CNAB.txt");
    }
	
	@Test(expected = CnabdemoGenericException.class)
    void testInvalidFileExecute() {
		transacaoFinanceiraService.processar("src/test/resources/xCNAB.txt");
    }
}
