package com.mycompany.desafiobanco.entities;

/**
 * Classe que representa uma conta corrente.
 * 
 * @autor danrleybrasil
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }
    
    @Override
    public String imprimirExtrato() {
        return "Extrato Conta Corrente:\n" + super.imprimirExtrato();
    }

}
