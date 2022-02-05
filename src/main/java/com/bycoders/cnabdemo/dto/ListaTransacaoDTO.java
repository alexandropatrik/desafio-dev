package com.bycoders.cnabdemo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bycoders.cnabdemo.enums.EDirecaoTransacao;

public class ListaTransacaoDTO {

	private List<TransacaoDTO> transacaoList = new ArrayList<TransacaoDTO>();
	private BigDecimal totalizador;
	
	public ListaTransacaoDTO() {
		super();
	}

	public List<TransacaoDTO> getTransacaoList() {
		return transacaoList;
	}

	public void setTransacaoList(List<TransacaoDTO> transacaoList) {
		this.transacaoList = transacaoList;
	}
	
	public void totalizar() {
		totalizador = transacaoList.
				stream().
				map(e -> e.getValor()).
				reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getTotalizador() {
		return totalizador;
	}

	
}
