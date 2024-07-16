package com.mycompany.desafiobanco.interfaces;

import com.mycompany.desafiobanco.entities.Cliente;
import com.mycompany.desafiobanco.entities.Conta;
import com.mycompany.desafiobanco.enums.TipoTransacao;

/**
 * Interface que define os metodos basicos para uma conta bancaria.
 * 
 * @autor danrleybrasil
 */
public interface iConta {

    String retirada(double valor);

    String depositar(double valor);

    String transferir(double valor, Conta contaDestino);

    String imprimirExtrato();

    void registrarTransacao(TipoTransacao tipo, double valor, Cliente outraParte);

    String imprimirHistoricoTransacoes();
}
