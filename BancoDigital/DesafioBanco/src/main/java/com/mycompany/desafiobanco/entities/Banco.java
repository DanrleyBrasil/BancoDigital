/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafiobanco.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dbs55
 */
@Getter
@Setter
public class Banco {

    private String nome;
    private List<Conta> contas;

}
