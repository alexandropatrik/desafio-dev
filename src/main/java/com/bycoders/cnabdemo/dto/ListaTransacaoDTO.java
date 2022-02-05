package com.bycoders.cnabdemo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListaTransacaoDTO {

	private String loja;
	private String dono;
	private List<TransacaoDTO> transacaoList = new ArrayList<>();
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
				map(TransacaoDTO::getValor).
				reduce(BigDecimal.ZERO, BigDecimal::add);
		if (!transacaoList.isEmpty()) {
			setDono(transacaoList.get(0).getDono());
		}
	}

	public BigDecimal getTotalizador() {
		return totalizador;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	
}
