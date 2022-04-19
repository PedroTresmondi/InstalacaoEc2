/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.verificacao;

import com.mycompany.omniview.monitoracao.loginswing.TelaLogin;
import com.mycompany.omniview.monitoracao.loginswing.TelaOpcao;
import com.mycompany.omniview.monitoracao.Connection;
import com.mycompany.omniview.monitoracao.usuario.TesteRecursos;
import com.mycompany.omniview.monitoracao.usuario.User;

import java.util.List;

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
                + "USUARIO WHERE ID=1");
        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");
    }

    public String getSenha() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIO WHERE ID=1");
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public String getId() {
        return this.id;
    }

    public static void CriarTabela() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    }

    public static void AutenticarLogin(String email, String senha,
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
            TelaOpcao tela = new TelaOpcao(usuarioId);
            tela.setVisible(true);
            TelaLogin teste = new TelaLogin();
            teste.setVisible(false);

            JOptionPane.showMessageDialog(null, "Autenticado");
            TesteRecursos.inserirDados();
        }
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
