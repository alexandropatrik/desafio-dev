package com.bycoders.cnabdemo;

import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CnabDemoApplicationTests {

    @Autowired
    private TransacaoFinanceiraService transacaoFinanceiraService;

    @Test
    void contextLoads() {
    }

    @Test
    void processar() {
        transacaoFinanceiraService.processar();
    }

}
