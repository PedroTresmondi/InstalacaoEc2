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
        MedicoesComputador recMemoria = new MedicoesComputador();

        infoSistema.informacoesDoSistemaAtual();
        System.out.println("Gravando dados na tabela Maquina");

        recMemoria.informacoesDoSistemaTotal();
        System.out.println("Gravando dados na tabela Medicoes");
        
        infoSistema.inserirHostName();
        System.out.println("Pegando Hostname e inserindo em MAQUINA");
        
        
        System.out.println(infoSistema.toString());
        
    }

}
