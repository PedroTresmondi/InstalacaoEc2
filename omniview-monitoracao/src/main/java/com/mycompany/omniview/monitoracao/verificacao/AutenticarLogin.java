/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.verificacao;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.monitoracao.loginswing.TelaLogin;
import com.mycompany.omniview.monitoracao.loginswing.TelaOpcao;
import com.mycompany.omniview.monitoracao.Connection;
import com.mycompany.omniview.monitoracao.usuario.MedicoesComputador;
import com.mycompany.omniview.monitoracao.usuario.RecursosComputador;
import com.mycompany.omniview.monitoracao.usuario.TesteRecursos;
import com.mycompany.omniview.monitoracao.usuario.User;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AutenticarLogin {

    private String email;
    private String senha;
    private String id;

    public AutenticarLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public AutenticarLogin() {
    }

    public String getEmail() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List emailUsuariosBanco = con.queryForList("SELECT EMAIL FROM "
                + "USUARIO WHERE EMAIL = ?", email);

        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");

    }

    public String getSenha() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIO WHERE SENHA = ?", senha);
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public String getId() {
        return this.id;
    }

    public void AutenticarLogin(String email, String senha,
            String emailUsuarioBanco, String senhaUsuarioBanco) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List<User> usuario = con.query("SELECT EMAIL, SENHA FROM USUARIO "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        List<User> usuarioId = con.query("SELECT ID FROM USUARIO "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        if (usuario.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Acesso negado \n Usuário ou "
                    + "senha incorretos");
        } else {
            inserirDados();

            TelaOpcao tela = new TelaOpcao(usuarioId);
            tela.setVisible(true);
            TelaLogin teste = new TelaLogin();
            teste.setVisible(false);

            this.email = emailUsuarioBanco;
            System.out.println("Email do banco" + emailUsuarioBanco);
            JOptionPane.showMessageDialog(null, "Autenticado");
            //inserirHostName
            try {
                String Inet = InetAddress.getLocalHost().getHostName();
                con.update("UPDATE MAQUINA SET HOSTNAME  = ? WHERE  ID = 500", Inet);

            } catch (UnknownHostException ex) {
                Logger.getLogger(RecursosComputador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

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
        //Insert na tabela maquina

    }

    public void inserirMaquinas() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        con.update("INSERT INTO MAQUINA(hostName,proprietarioMaq,"
                + "tipo,sistemaOperacional,ramTotal,arquitetura,"
                + "processador,disco,Fk_EstMaq) VALUES "
                + " (null,?,null,?,?,?,?,?,?)", this.email, sistemaOperacional, memoriaRamTotal,
                arquiteturaSis, processador, quantidadeDiscos, 1);

       
    }

    public static void inserirDados() {
        RecursosComputador infoSistema = new RecursosComputador();
        MedicoesComputador recMemoria = new MedicoesComputador();

        infoSistema.informacoesDoSistemaAtual();
        System.out.println("Gravando dados na tabela Maquina");

        recMemoria.informacoesDoSistemaTotal();
        System.out.println("Gravando dados na tabela Medicoes");

        System.out.println(infoSistema.toString());

    }


    public static void RegistrarCaixa(java.awt.event.ActionEvent evt,
            Boolean checkCaixa, String id) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkCaixa = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Caixa!");
            con.update("UPDATE MAQUINA SET TIPO='C' WHERE ID=500");

            List teste = con.queryForList("SELECT * FROM "
                    + "MAQUINA WHERE ID=500 ");
            System.out.println(teste);
            System.out.println("Caixa cadastrado");

        } else {
            System.out.println("caixa nao cadastrado");
        }
    }

    public static void RegistrarTotem(java.awt.event.ActionEvent evt,
            Boolean checkTotem) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkTotem = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Totem!");
            con.execute("UPDATE MAQUINA SET TIPO='T'  WHERE ID=500");

            List teste = con.queryForList("SELECT * FROM "
                    + "MAQUINA WHERE ID =500");

            teste.get(0).toString().replace("{EMAIL=", "").replace("}", "");
            System.out.println(teste);

            System.out.println("Totem cadastrado ");

        } else {
            System.out.println("totem nao cadastrado");
        }

    }

    public static void AbrirLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }

        });

    }

}
