/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;


import com.mycompany.omniview.monitoracao.verificacao.AutenticarLogin;

import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        AutenticarLogin.AbrirLogin();
        
    }
}
