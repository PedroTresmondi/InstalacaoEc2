/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.monitoracao.Connection;
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
    private Double discoTotal;
    private Integer arquiteturaSis;
    private Double memoriaRam;
    private Double memoriaRamTotal;
    private List processos;
    private Integer quantidadeDiscos;
    private Double cpuTotal;

    Looca looca = new Looca();
    
    public void informarHostName(){
    

    }

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
        Long memoriaRamByte = looca.getMemoria().getEmUso();
        memoriaRam = memoriaRamByte / 1073741824.0;

        quantidadeDiscos = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();

        //Insert na tabela maquina
        con.update("INSERT INTO MAQUINA VALUES (null, null, ?,?,?,?,?,null)",
                sistemaOperacional, memoriaRam,
                arquiteturaSis, processador, quantidadeDiscos);

    }

    public void informacoesDoSistemaTotal() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        //(RAM TOTAL
        Long memoriaRamInsByte = looca.getMemoria().getTotal();
        memoriaRamTotal = memoriaRamInsByte / 1073741824.0;

        //Pega a quantidade de processos sendo executados no momento
        processos = looca.getGrupoDeServicos().getServicosInativos();

        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        discoTotal = discoByte / 1073741824.0;

        //CPU
        Long cpuBytes = looca.getProcessador().getFrequencia();
        cpuTotal = cpuBytes / 1073741824.0;

        //HORARIO
        //insert na tabela recursos(tabela estatica onde mostra o 
        //TOTAL de cada componente)
        //con.update("INSERT INTO RECURSOS VALUES (null, ?,?,?,?,null,null,null)", memoriaRamTotal, discoTotal, cpuTotal, processos);

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

    /*@Override
    public String toString() {
        return String.format("Processador: %s \n"
                + "Total de bits: %d \n"
                + "Sistema Operacional: %s \n"
                + "Total Disco: %.2fGB \n"
                + "Arquitetura do sistema: %dx "
                + "\n"
                + "-------Memória-------", processador, bitMaquina,
                sistemaOperacional,
                 arquiteturaSis, looca.getMemoria());
    }
     */
}
