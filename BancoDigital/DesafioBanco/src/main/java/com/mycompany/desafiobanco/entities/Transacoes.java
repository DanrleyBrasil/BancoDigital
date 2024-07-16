package com.mycompany.desafiobanco.entities;

import com.mycompany.desafiobanco.enums.TipoTransacao;
import java.sql.Timestamp;
import lombok.Getter;

/**
 * Classe que representa uma transacao bancaria.
 * 
 * @autor danrleybrasil
 */
@Getter
public class Transacoes {

    private TipoTransacao tipo;
    private double valor;
    private Timestamp dataHora;
    private Cliente outraParte;

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
            return String.format("[%s] - Valor: %.2f - Data/Hora: %s - Transacao Interna", tipo, valor, dataHora);
        }
    }
}
