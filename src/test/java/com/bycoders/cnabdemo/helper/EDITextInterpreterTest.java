package com.bycoders.cnabdemo.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.dto.TransacaoFinanceiraDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CnabDemoApplication.class)
public class EDITextInterpreterTest {

	@Test
	public void testReadLine() {
		TransacaoFinanceiraDTO t = new TransacaoFinanceiraDTO();
		t.setTipoTransacao("FINANCIAMENTO");
		t.setData("20190301");
		t.setValor("0000014200");
		t.setCpf("09620676017");
		t.setCartao("4753****3153");
		t.setHora("153453");
		t.setDono("JOÃO MACEDO");
		t.setLoja("BAR DO JOÃO");
		
		EDITextInterpreter edi = new TransacaoFinanceiraDTO("3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       ");
		edi.readLine();
		assertEquals(edi, t);
	}

	@Test
	public void testSetLinha() {
		String ilinha = "";
		EDITextInterpreter instance = new EDITextInterpreterImpl();
		instance.setLinha(ilinha);
		assertEquals(ilinha, instance.getLinha());
	}
	
	public class EDITextInterpreterImpl extends EDITextInterpreter {
    }

}
