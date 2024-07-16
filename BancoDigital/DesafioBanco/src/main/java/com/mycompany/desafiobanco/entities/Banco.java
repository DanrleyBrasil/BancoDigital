package com.mycompany.desafiobanco.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um banco com um nome e uma lista de contas.
 * 
 * @autor danrleybrasil
 */
@Getter
@Setter
public class Banco {

    private String nome;
    private List<Conta> contas;

}
