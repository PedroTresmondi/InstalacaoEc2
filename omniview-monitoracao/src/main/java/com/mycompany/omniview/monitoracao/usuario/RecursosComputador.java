/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.monitoracao.Connection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mariana.cazzoto
 */
public class RecursosComputador {

    private String processador;
    private Integer bitMaquina;
    private String sistemaOperacional;

    private Integer arquiteturaSis;
    private Double memoriaRam;
    private Double memoriaRamTotal;
    private List processos;
    private Integer quantidadeDiscos;
    private Double cpuTotal;

    Looca looca = new Looca();

    public void informacoesDoSistemaAtual() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        //Pega o nome do processador
        processador = looca.getProcessador().getNome();

        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();

        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();

        //Arquitetura do processador
        arquiteturaSis = looca.getSistema().getArquitetura();
        //Memoria ram convertida de bytes para Gigas
        //(RAM EM USO)
        Long memoriaRamByte = looca.getMemoria().getTotal().longValue();
        memoriaRamTotal = memoriaRamByte / 1073741824.0;

        quantidadeDiscos = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();

    }
}

/*
     InetAddress.getLocalHost().getHostName()
                    
                    } catch (UnknownHostException ex) {
            Logger.getLogger(AutenticarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
 insertHostName(){
        InetAddress.getLocalHost().getHostName()
 */
