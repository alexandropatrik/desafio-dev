package com.bycoders.cnabdemo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CnabDemoApplication.class)
public class TransacaoFinanceiraServiceTest {

	@Autowired
	TransacaoFinanceiraService transacaoFinanceiraService;
	
	@Test
    public void testExecute() {
		transacaoFinanceiraService.processar("src/test/resources/CNAB.txt");
    }
}
