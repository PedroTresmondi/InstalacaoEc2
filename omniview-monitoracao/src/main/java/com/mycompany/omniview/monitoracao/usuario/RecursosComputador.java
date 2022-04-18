/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.mycompany.omniview.monitoracao.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public void informacoesDoSistema() {

        //Pega o nome do processador
        processador = looca.getProcessador().getNome();

        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();

        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();

        //Total de Disco
        disco = looca.getGrupoDeDiscos().getTamanhoTotal();
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    
    public void gravarDados() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
 
    }

    public void informacaomemoria() {

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
        return "-----Processador-----\n" + processador
                + "\n-----Total de bits-----\n" + bitMaquina
                + "\n-----Sistema Operacional-----\n" + sistemaOperacional
                + "\n-----Total Disco-----\n" + disco
                + "\n-----Memória-----\n" + looca.getMemoria();
    }

}
