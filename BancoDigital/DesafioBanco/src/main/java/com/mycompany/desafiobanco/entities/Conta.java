/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafiobanco.entities;

import com.mycompany.desafiobanco.enums.TipoTransacao;
import com.mycompany.desafiobanco.interfaces.iConta;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbs55
 */
public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    private List<Transacoes> historicoTransacoes;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected TipoTransacao trasacaoAtual;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        historicoTransacoes = new ArrayList<>();
    }

    @Override
    public void retirada(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            if (trasacaoAtual != TipoTransacao.TRANSFERENCIA_ENVIADA) {
                registrarTransacao(TipoTransacao.SAQUE, valor, null); // Transação interna, outraParte é nula
            }
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        if (trasacaoAtual != TipoTransacao.TRANSFERENCIA_RECEBIDA) {
            registrarTransacao(TipoTransacao.DEPOSITO, valor, null); // Transação interna, outraParte é nula
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        trasacaoAtual = TipoTransacao.TRANSFERENCIA_ENVIADA;
        if (saldo >= valor) {
            this.retirada(valor); // Deduzindo o valor transferido da conta de origem
            // Registrando a transação como uma transferência
            this.registrarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, contaDestino.cliente);
            contaDestino.trasacaoAtual = TipoTransacao.TRANSFERENCIA_RECEBIDA;
            contaDestino.depositar(valor); // Creditando o valor transferido na conta de destino
            contaDestino.registrarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, this.cliente);

        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    // Método para registrar uma transação
    @Override
    public void registrarTransacao(TipoTransacao tipo, double valor, Cliente outraParte) {
        Transacoes transacao = new Transacoes(tipo, valor, new Timestamp(System.currentTimeMillis()), outraParte);
        historicoTransacoes.add(transacao);
    }

    // Método para imprimir o histórico de transações
    @Override
    public void imprimirHistoricoTransacoes() {
        System.out.println("Histórico de Transações:");
        for (Transacoes transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
