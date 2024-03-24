/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.desafiobanco.interfaces;

import com.mycompany.desafiobanco.entities.Cliente;
import com.mycompany.desafiobanco.entities.Conta;
import com.mycompany.desafiobanco.enums.TipoTransacao;

/**
 *
 * @author dbs55
 */
public interface iConta {

    void retirada(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

    void registrarTransacao(TipoTransacao tipo, double valor, Cliente outraParte); // Adicionando o método de registro de transação na interface

    void imprimirHistoricoTransacoes(); // Adicionando o método de impressão do histórico de transações na interface
}
