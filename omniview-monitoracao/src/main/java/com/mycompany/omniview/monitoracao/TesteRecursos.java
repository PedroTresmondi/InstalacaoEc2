/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ominiview;

/**
 *
 * @author mariana.cazzoto
 */
public class TesteRecursos {
    public static void main(String[] args) {
        RecursosComputador infoSistema = new RecursosComputador();
        RecursosComputador recMemoria = new RecursosComputador();

        infoSistema.informacoesDoSistema();
        System.out.println(infoSistema);
        
        recMemoria.informacaomemoria();
        System.out.println(recMemoria);

        
    }
}
