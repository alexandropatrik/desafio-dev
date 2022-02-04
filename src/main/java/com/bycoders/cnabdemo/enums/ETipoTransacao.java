package com.bycoders.cnabdemo.enums;

/**
 *
 * @author patrik 
 * Enum que define os tipos de transações mapeadas no sistema
 * Identificado pelo atributo tipo, possui uma descrição e é vinculado a uma
 * direção (entrada ou saída)
 */
public enum ETipoTransacao {

    DEBITO(1, "Débito", EDirecaoTransacao.ENTRADA),
    BOLETO(2, "Boleto", EDirecaoTransacao.SAIDA),
    FINANCIAMENTO(3, "Financiamento", EDirecaoTransacao.SAIDA),
    CREDITO(4, "Crédito", EDirecaoTransacao.ENTRADA),
    RECEBIMENTO_EMPRESTIMO(5, "Recebimento Empréstimo", EDirecaoTransacao.ENTRADA),
    VENDAS(6, "Vendas", EDirecaoTransacao.ENTRADA),
    RECEBIMENTO_TED(7, "Recebimento TED", EDirecaoTransacao.ENTRADA),
    RECEBIMENTO_DOC(8, "Recebimento DOC", EDirecaoTransacao.ENTRADA),
    ALUGUEL(9, "Aluguel", EDirecaoTransacao.SAIDA);

    private Integer tipo;
    private String descricao;
    private EDirecaoTransacao direcao;

    private ETipoTransacao(Integer tipo, String descricao,
            EDirecaoTransacao direcao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.direcao = direcao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public EDirecaoTransacao getDirecao() {
        return direcao;
    }

    public static ETipoTransacao getTipoTransacao(Integer tipo) {
        for (ETipoTransacao e : ETipoTransacao.values()) {
            if (e.getTipo()== tipo) {
                return e;
            }
        }
        return null;
    }
    
}
