package com.bycoders.cnabdemo.dto;

import com.bycoders.cnabdemo.annotations.EDITextField;
import com.bycoders.cnabdemo.entities.TransacaoFinanceira;
import com.bycoders.cnabdemo.enums.EDirecaoTransacao;
import com.bycoders.cnabdemo.enums.ETipoTransacao;
import com.bycoders.cnabdemo.helper.EDITextInterpreter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * Classe de modelo do CNAB, que extende EDITextInterpreter
 * São mapeados os atributos que devem ser lidos do arquivo
 * 
 * @author patrik
 */
public class TransacaoFinanceiraDTO extends EDITextInterpreter implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EDITextField(start = 0, end = 1)
    private String tipoTransacao;
    @EDITextField(start = 1, end = 9)
    private String data;
    @EDITextField(start = 9, end = 19)
    private String valor;
    @EDITextField(start = 19, end = 30)
    private String cpf;
    @EDITextField(start = 30, end = 42)
    private String cartao;
    @EDITextField(start = 42, end = 48)
    private String hora;
    @EDITextField(start = 48, end = 62)
    private String dono;
    @EDITextField(start = 62, end = 80)
    private String loja;

    public TransacaoFinanceiraDTO() {
    }

    public TransacaoFinanceiraDTO(String ilinha) {
        super.setLinha(ilinha);
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "TransacaoFinanceiraDTO [tipoTransacao=" + tipoTransacao + ", data=" + data + ", valor=" + valor
				+ ", cpf=" + cpf + ", cartao=" + cartao + ", hora=" + hora + ", dono=" + dono + ", loja=" + loja + "]";
	}
    
	
	public TransacaoFinanceira toEntity() {
		TransacaoFinanceira t = new TransacaoFinanceira();
		t.setTipoTransacao(ETipoTransacao.getTipoTransacao(Integer.parseInt(tipoTransacao)));
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		t.setDataTransacao(LocalDate.parse(data, formatterDate));
		t.setValor(new BigDecimal(valor).divide(BigDecimal.valueOf(100L)).multiply(t.getTipoTransacao().getDirecao().equals(EDirecaoTransacao.ENTRADA) ? BigDecimal.ONE : new BigDecimal(-1)));
		t.setCpf(cpf.trim());
		t.setCartao(cartao.trim());
		t.setDono(dono.trim());
		t.setLoja(loja.trim());
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HHmmss");
		t.setHora(LocalTime.parse(hora, formatterTime));
		return t;
	}
    
    
}
