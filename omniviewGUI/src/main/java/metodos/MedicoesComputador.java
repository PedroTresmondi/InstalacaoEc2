/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.Connection;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

public class MedicoesComputador {

    private Double memoriaRam;
    private Integer qtdProcessos;
    private Double cpuEmUso;
    private Double discoEmUso;
    
    metodos.AlertasSlack slack = new AlertasSlack();
    metodos.RecursosComputador regMaq = new RecursosComputador();

    public MedicoesComputador() {
    }

    Looca looca = new Looca();
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    RecursosComputador rec = new RecursosComputador();
    metodos.ConsultaBanco cntsBanco = new ConsultaBanco();

    public Double getMemoriaRam() {
        Long memoriaByte = looca.getMemoria().getEmUso();
        Double memoriaGigaByte = memoriaByte / 1073741824.0;
       memoriaRam = memoriaGigaByte;
        return memoriaRam;
    }

    public Integer getProcessos() {
        qtdProcessos = qtdProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
        
        return qtdProcessos;
    }

    public Double getCpuEmUso() {
       cpuEmUso = looca.getProcessador().getUso();
       return cpuEmUso;
    }

    public Double getDiscoDisponivel() {
        Long discoByte = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel();
        Double discoGigaByte = discoByte / 1073741824.0;
        discoEmUso = discoGigaByte;

        return discoEmUso;
    }

    Timer timer1 = new Timer();

    public void inserirMedicao() {
        int delay = 5000;
        int interval = 7000;

        timer1.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                con.update("Insert into medicoes"
                        + " (ram,usoDoDisco,cpuM,processos,diaHorario,Fk_MaqRe) "
                        + "values (?, ?, ?, ?,GETDATE(),?)",
                        getMemoriaRam(), getDiscoDisponivel(),
                        getCpuEmUso(), getProcessos(), cntsBanco.getIDMaquina());
                System.out.println("Inserindo dados na tabela medicoes");

                slack.alertaRam(memoriaRam, regMaq.getMemoriaRamTotal(), regMaq.getHostname());
                slack.alertaDisco(getDiscoDisponivel(), regMaq.getDiscoTotal(), regMaq.getHostname());
            }
        }, delay, interval);
    }

  

}
