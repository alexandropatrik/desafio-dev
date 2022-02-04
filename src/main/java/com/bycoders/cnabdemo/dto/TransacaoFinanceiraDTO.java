package com.bycoders.cnabdemo.dto;

import com.bycoders.cnabdemo.annotations.EDITextField;
import com.bycoders.cnabdemo.enums.ETipoTransacao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

    
/*
    
| Descrição do campo  | Inicio | Fim | Tamanho | Comentário
| ------------- | ------------- | -----| ---- | ------
| Tipo  | 1  | 1 | 1 | Tipo da transação
| Data  | 2  | 9 | 8 | Data da ocorrência
| Valor | 10 | 19 | 10 | Valor da movimentação. *Obs.* O valor encontrado no arquivo precisa ser divido por cem(valor / 100.00) para normalizá-lo.
| CPF | 20 | 30 | 11 | CPF do beneficiário
| Cartão | 31 | 42 | 12 | Cartão utilizado na transação 
| Hora  | 43 | 48 | 6 | Hora da ocorrência atendendo ao fuso de UTC-3
| Dono da loja | 49 | 62 | 14 | Nome do representante da loja
| Nome loja | 63 | 81 | 19 | Nome da loja    
    
    */    

/**
 *
 * @author patrik
 */
public class TransacaoFinanceiraDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    @EDITextField(start = 1, end = 2)
    private ETipoTransacao tipoTransacao;
    @EDITextField(start = 2, end = 10)
    private LocalDate data;
    @EDITextField(start = 10, end = 20)
    private BigDecimal valor;
    @EDITextField(start = 20, end = 31)
    private String cpf;
    @EDITextField(start = 31, end = 43)
    private String cartao;
    @EDITextField(start = 43, end = 49)
    private LocalTime hora;
    @EDITextField(start = 49, end = 63)
    private String dono;
    @EDITextField(start = 63, end = 82)
    private String loja;

    public TransacaoFinanceiraDTO() {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
