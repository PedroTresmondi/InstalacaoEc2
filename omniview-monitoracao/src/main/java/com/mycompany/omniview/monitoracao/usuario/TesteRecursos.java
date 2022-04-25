/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

/**
 *
 * @author mariana.cazzoto
 */
public class TesteRecursos {

    public static void inserirDados() {
        RecursosComputador infoSistema = new RecursosComputador();
        RecursosComputador recMemoria = new RecursosComputador();

        infoSistema.informacoesDoSistemaAtual();
        System.out.println("Gravando dados na tabela Maquina");

        infoSistema.informacoesDoSistemaTotal();
        System.out.println("Gravando dados na tabela Recursos");
    }

}
