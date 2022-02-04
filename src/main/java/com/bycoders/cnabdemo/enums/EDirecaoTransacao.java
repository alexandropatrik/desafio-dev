package com.bycoders.cnabdemo.enums;
/**
 *
 * @author patrik
 * Enum que indica se a transacao é ENTRADA ou SAIDA
 * vincula também o sinal para exibir no extrato
 */
public enum EDirecaoTransacao {
    
    ENTRADA("Entrada", '+'),
    SAIDA("Saída", '-');
    
    private String natureza;
    private char sinal;

    private EDirecaoTransacao(String natureza, char sinal) {
        this.natureza = natureza;
        this.sinal = sinal;
    }

    private EDirecaoTransacao() {
    }

    public String getNatureza() {
        return natureza;
    }

    public char getSinal() {
        return sinal;
    }

    @Override
    public String toString() {
        return natureza;
    }
    
    
}