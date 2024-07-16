package com.mycompany.desafiobanco.enums;

/**
 * Enumeração que define os tipos de transacoes possiveis.
 * 
 * @autor danrleybrasil
 */
public enum TipoTransacao {
    DEPOSITO("Deposito"),
    SAQUE("Saque"),
    TRANSFERENCIA_ENVIADA("Transferencia enviada"),
    TRANSFERENCIA_RECEBIDA("Transferencia recebida");

    private final String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
