/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafiobanco.entities;

import com.mycompany.desafiobanco.enums.TipoTransacao;
import java.sql.Timestamp;
import lombok.Getter;

/**
 *
 * @author dbs55
 */
@Getter
public class Transacoes {

    private TipoTransacao tipo; // Pode ser "Depósito", "Saque" ou "Transferência"
    private double valor;
    private Timestamp dataHora;
    private Cliente outraParte; // Cliente envolvido na transação (ou a própria conta)


    public Transacoes(TipoTransacao tipo, double valor, Timestamp dataHora, Cliente outraParte) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.outraParte = outraParte;
    }

    @Override
    public String toString() {
        if (outraParte != null) {
            return String.format("[%s] - Valor: %.2f - Data/Hora: %s - Parte Envolvida: %s", tipo, valor, dataHora, outraParte.getNome());
        } else {
            return String.format("[%s] - Valor: %.2f - Data/Hora: %s - Transação Interna", tipo, valor, dataHora);
        }
    }
}
