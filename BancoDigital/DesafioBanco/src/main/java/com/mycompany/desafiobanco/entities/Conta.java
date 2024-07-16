package com.mycompany.desafiobanco.entities;

import com.mycompany.desafiobanco.enums.TipoTransacao;
import com.mycompany.desafiobanco.interfaces.iConta;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa uma conta bancaria generica.
 * 
 * @autor danrleybrasil
 */
public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private List<Transacoes> historicoTransacoes;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected TipoTransacao transacaoAtual;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        historicoTransacoes = new ArrayList<>();
    }

    @Override
    public String retirada(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            if (transacaoAtual != TipoTransacao.TRANSFERENCIA_ENVIADA) {
                registrarTransacao(TipoTransacao.SAQUE, valor, null);
            }
            return "Cliente " + cliente.getNome() + " sacou " + valor + ".";
        } else {
            return "Saldo insuficiente.";
        }
    }

    @Override
    public String depositar(double valor) {
        saldo += valor;
        if (transacaoAtual != TipoTransacao.TRANSFERENCIA_RECEBIDA) {
            registrarTransacao(TipoTransacao.DEPOSITO, valor, null);
        }
        return "Cliente " + cliente.getNome() + " depositou " + valor + ".";
    }

    @Override
    public String transferir(double valor, Conta contaDestino) {
        transacaoAtual = TipoTransacao.TRANSFERENCIA_ENVIADA;
        if (saldo >= valor) {
            this.retirada(valor);
            this.registrarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, contaDestino.cliente);
            contaDestino.transacaoAtual = TipoTransacao.TRANSFERENCIA_RECEBIDA;
            contaDestino.depositar(valor);
            contaDestino.registrarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, this.cliente);
            return "Cliente " + cliente.getNome() + " transferiu " + valor + " para Cliente " + contaDestino.cliente.getNome() + ".";
        } else {
            return "Saldo insuficiente para realizar a transferencia.";
        }
    }

    @Override
    public void registrarTransacao(TipoTransacao tipo, double valor, Cliente outraParte) {
        Transacoes transacao = new Transacoes(tipo, valor, new Timestamp(System.currentTimeMillis()), outraParte);
        historicoTransacoes.add(transacao);
    }

    @Override
    public String imprimirHistoricoTransacoes() {
        StringBuilder historico = new StringBuilder("Historico de Transacoes de " + cliente.getNome() + ":\n");
        for (Transacoes transacao : historicoTransacoes) {
            historico.append(transacao).append("\n");
        }
        return historico.toString();
    }

    @Override
    public String imprimirExtrato() {
        StringBuilder extrato = new StringBuilder("Extrato da Conta de " + cliente.getNome() + ":\n");
        extrato.append(String.format("Agencia: %d\n", this.agencia));
        extrato.append(String.format("Numero: %d\n", this.numero));
        extrato.append(String.format("Saldo: %.2f\n", this.saldo));
        return extrato.toString();
    }
}
