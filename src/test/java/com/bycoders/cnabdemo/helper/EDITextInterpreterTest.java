package com.bycoders.cnabdemo.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoders.cnabdemo.CnabDemoApplication;
import com.bycoders.cnabdemo.dto.TransacaoFinanceiraDTO;
import com.bycoders.cnabdemo.entities.TransacaoFinanceira;

@SpringBootTest(classes = CnabDemoApplication.class)
class EDITextInterpreterTest {

	@Test
	public void testReadLine() {
		TransacaoFinanceiraDTO t = new TransacaoFinanceiraDTO();
		t.setTipoTransacao("3");
		t.setData("20190301");
		t.setValor("0000014200");
		t.setCpf("09620676017");
		t.setCartao("4753****3153");
		t.setHora("153453");
		t.setDono("JOÃO MACEDO");
		t.setLoja("BAR DO JOÃO");
		
		EDITextInterpreter edi = new TransacaoFinanceiraDTO("3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       ");
		edi.readLine();
		
		
		TransacaoFinanceira t1 = t.toEntity();
		TransacaoFinanceira t2 = ((TransacaoFinanceiraDTO)edi).toEntity();
		
		assertEquals(t1, t2);
		
		assertEquals(t1.getTipoTransacao(), t2.getTipoTransacao());
		assertEquals(Boolean.TRUE, t1.getDataTransacao().equals(t2.getDataTransacao()));
		assertEquals(t1.getValor(), t2.getValor());
		assertEquals(t1.getCpf(), t2.getCpf());
		assertEquals(t1.getCartao(), t2.getCartao());
		assertEquals(t1.getHora(), t2.getHora());
		assertEquals(t1.getDono(), t2.getDono());
		assertEquals(t1.getLoja(), t2.getLoja());
		
		assertEquals(Boolean.TRUE, t1.equals(t2));
	}

	@Test
	void testSetLinha() {
		String ilinha = "";
		EDITextInterpreter instance = new EDITextInterpreterImpl();
		instance.setLinha(ilinha);
		assertEquals(ilinha, instance.getLinha());
	}
	
	public class EDITextInterpreterImpl extends EDITextInterpreter {
    }

}
