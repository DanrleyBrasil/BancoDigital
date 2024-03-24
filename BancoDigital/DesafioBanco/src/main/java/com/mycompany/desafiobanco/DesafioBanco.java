/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.desafiobanco;

import com.mycompany.desafiobanco.entities.Cliente;
import com.mycompany.desafiobanco.entities.Conta;
import com.mycompany.desafiobanco.entities.ContaCorrente;
import com.mycompany.desafiobanco.entities.ContaPoupanca;

/**
 *
 * @author dbs55
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

        // Simulando transações
        ccDanrley.depositar(2000d);
        System.out.println("Cliente Danrley depositou 2000.");

        ccDanrley.retirada(1000d);
        System.out.println("Cliente Danrley sacou 1000.");

        ccDanrley.transferir(500d, ccGabriella);
        System.out.println("Cliente Danrley transferiu 500 para Cliente Gabriella.");

        ccGabriella.retirada(250d);
        System.out.println("Cliente Gabriella sacou 250.");

        ccGabriella.transferir(250d, ccMargarete);
        System.out.println("Cliente Gabriella transferiu 250 para Cliente Margarete.");

        // Imprimindo extratos
        System.out.println("\nExtrato da Conta Corrente de Danrley:");
        ccDanrley.imprimirExtrato();

        System.out.println("\nExtrato da Conta Poupança de Danrley:");
        cpDanrley.imprimirExtrato();

        System.out.println("\nExtrato da Conta Corrente de Gabriella:");
        ccGabriella.imprimirExtrato();

        System.out.println("\nExtrato da Conta Corrente de Margarete:");
        ccMargarete.imprimirExtrato();

        // Imprimindo histórico de transações
        System.out.println("\nHistórico de transações de Danrley:");
        ccDanrley.imprimirHistoricoTransacoes();

        System.out.println("\nHistórico de transações de Gabriella:");
        ccGabriella.imprimirHistoricoTransacoes();

    }
}
