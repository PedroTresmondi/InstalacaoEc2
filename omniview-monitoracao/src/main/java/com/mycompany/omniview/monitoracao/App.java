/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import com.mycompany.omniview.monitoracao.usuario.User;
import com.mycompany.omniview.monitoracao.verificacao.AutenticarLogin;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        User usuario1 = new User();

        // Usuario usuario1 = new Usuario(01, "teste@email.com", "teste");
        //AutenticarLogin.CriarTabela();
        AutenticarLogin.AbrirLogin();
    }
}
