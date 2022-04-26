    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.monitoracao.Connection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro.h.tresmondi
 */
public class MedicoesComputador {

    private Double memoriaRam;
    private Double memoriaRamTotal;
    private Integer processos;
    private Integer quantidadeDiscos;
    private Double cpuTotal;
    private Double discoTotal;
    Looca looca = new Looca();

    public void informacoesDoSistemaTotal() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        //(RAM TOTAL
        Long memoriaRamInsByte = looca.getMemoria().getTotal();
        memoriaRamTotal = memoriaRamInsByte / 1073741824.0;

        //Pega a quantidade de processos sendo executados no momento
        processos = looca.getGrupoDeProcessos().getTotalProcessos();
        

        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        discoTotal = discoByte / 1073741824.0;

        //CPU
        Long cpuBytes = looca.getProcessador().getFrequencia();
        cpuTotal = cpuBytes / 1073741824.0;

        Long memoriaRamByte = looca.getMemoria().getEmUso();
        memoriaRam = memoriaRamByte / 1073741824.0;

        //HORARIO
        //insert na tabela recursos(tabela estatica onde mostra o 
        //TOTAL de cada componente)
        con.update("INSERT INTO medicoes(ram,disco,cpuM,processos,"
                + "diaHorario, Fk_MaqRe) VALUES (?,?,?,?,GETDATE(),500)",
                 memoriaRam,discoTotal,cpuTotal,processos);

    }
}
