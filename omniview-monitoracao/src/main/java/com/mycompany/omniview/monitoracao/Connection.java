/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import com.mysql.cj.xdevapi.Statement;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private BasicDataSource datasource;

    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public Connection() {
     
        this.datasource = new BasicDataSource();
        //this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //this.datasource.setUrl("jdbc:sqlserver://meubanco.database.windows.net/meubanco");
        this.datasource.setUrl("jdbc:mysql://localhost:3306/omniview?useTimezone=true&serverTimezone=UTC");
        this.datasource.setUsername("root");
        this.datasource.setPassword("M3e4r7y1!");

        // Não irá funcionar se você não criar um container exatamente igual o meu.
        // usuário utilizado em um container MySQL
        //this.datasource.setUsername("root");
        // senha padrao utilizada no container MySQL
        //this.datasource.setPassword("teste");
       
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
    
}
