package com.bycoders.cnabdemo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.bycoders.cnabdemo.enums.ETipoTransacao;

/**
 * Classe para representar uma transacao quando
 * é requisitada pelo front
 * @author patrik
 *
 */
public class TransacaoDTO {
	
    private Long id;
    private ETipoTransacao tipoTransacao;
    private LocalDate dataTransacao;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private LocalTime hora;
    private String dono;
    private String loja;
    
	public TransacaoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ETipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(ETipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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

}
