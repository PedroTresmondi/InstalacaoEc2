/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ominiview;

import com.github.britooo.looca.api.core.Looca;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariana.cazzoto
 */
public class RecursosComputador {
    
    private String processador;
    private Integer bitMaquina;
    private String sistemaOperacional;
    private Long disco;
   
    Looca looca = new Looca();
    
    public void informacoesDoSistema(){
        //Pega o nome do processador
        processador = looca.getProcessador().getNome();
        
        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();
        
        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        
        //Total de Disco
        disco = looca.getGrupoDeDiscos().getTamanhoTotal();
    }

    public void informacaomemoria(){
        //Pega as informações da memoria a cada 5 segundos
        while (true) {

            // try = tentar , se der erro vai pro catch
            // thread = tarefas 
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TesteRecursos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(looca.getMemoria());
        }
    }

    @Override
    public String toString() {
        return "-----Processador-----\n"+ processador
             + "\n-----Total de bits-----\n" + bitMaquina
             + "\n-----Sistema Operacional-----\n" + sistemaOperacional
             + "\n-----Total Disco-----\n" + disco
             + "\n-----Memória-----\n" + looca.getMemoria();
    }
    
}
