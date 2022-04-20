/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.mycompany.omniview.monitoracao.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro.h.tresmondi
 */
public class User {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    private String email;
    private String senha;
    private Integer id;
    private String hostName;

    public User() {
    }

    public User(Integer Id, String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

   
    
   

    //StringBuilder createStatement = new StringBuilder();
    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "email =" + email + "senha =" + senha;
    }

    
    
    
    
    
}
