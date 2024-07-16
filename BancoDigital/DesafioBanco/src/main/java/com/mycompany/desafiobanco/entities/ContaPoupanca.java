package com.mycompany.desafiobanco.entities;

/**
 * Classe que representa uma conta poupanca.
 * 
 * @autor danrleybrasil
 */
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String imprimirExtrato() {
        return "Extrato Conta Poupanca:\n" + super.imprimirExtrato();
    }

}
