package com.bycoders.cnabdemo.resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CnabDemoApplication.class)
@WebMvcTest(TransacaoFinanceiraResource.class)
public class TransacaoFinanceiraResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransacaoFinanceiraService service;
	
	@Test
	public void processarArquivoEndpoint() {
		
	}
	
	
	
}
