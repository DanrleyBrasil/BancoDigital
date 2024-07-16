package com.mycompany.desafiobanco;

import com.mycompany.desafiobanco.entities.Cliente;
import com.mycompany.desafiobanco.entities.Conta;
import com.mycompany.desafiobanco.entities.ContaCorrente;
import com.mycompany.desafiobanco.entities.ContaPoupanca;

/**
 * Classe principal para simulacao de operacoes bancarias.
 * 
 * @autor danrleybrasil
 */
public class DesafioBanco {

    public static void main(String[] args) {
        // Criando clientes
        Cliente danrley = new Cliente("Danrley");
        Cliente gabriella = new Cliente("Gabriella");
        Cliente margarete = new Cliente("Margarete");

        // Criando contas para os clientes
        Conta ccDanrley = new ContaCorrente(danrley);
        Conta cpDanrley = new ContaPoupanca(danrley);
        Conta ccGabriella = new ContaCorrente(gabriella);
        Conta ccMargarete = new ContaCorrente(margarete);

        // Simulando transacoes
        System.out.println(ccDanrley.depositar(2000d));
        System.out.println(ccDanrley.retirada(1000d));
        System.out.println(ccDanrley.transferir(500d, ccGabriella));
        System.out.println(ccGabriella.retirada(250d));
        System.out.println(ccGabriella.transferir(250d, ccMargarete));

        // Imprimindo extratos
        System.out.println(ccDanrley.imprimirExtrato());
        System.out.println(cpDanrley.imprimirExtrato());
        System.out.println(ccGabriella.imprimirExtrato());
        System.out.println(ccMargarete.imprimirExtrato());

        // Imprimindo historico de transacoes
        System.out.println(ccDanrley.imprimirHistoricoTransacoes());
        System.out.println(ccGabriella.imprimirHistoricoTransacoes());
    }
}
