package com.bycoders.cnabdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoders.cnabdemo.resource.TransacaoFinanceiraResource;

@SpringBootTest
class CnabDemoApplicationTest {

	@Autowired
	private TransacaoFinanceiraResource controller;
	
	@Test
    void contextLoads() {
		assertThat(controller).isNotNull();
    }

}
