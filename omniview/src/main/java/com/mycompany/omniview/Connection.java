/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview;

import com.mysql.cj.xdevapi.Statement;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private BasicDataSource datasource;

    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public Connection() {

        this.datasource = new BasicDataSource();

        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl("jdbc:sqlserver://svr-omniview.database.windows.net:1433;database=meu_banco;user=admin-ominiview@svr-omniview;password={2ads#grupo7};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

        //this.datasource.setUrl("jdbc:mysql://localhost:3306/omniview?useTimezone=true&serverTimezone=UTC");
        this.datasource.setPassword("2ads#grupo7");
        
        this.datasource.setDriverClassName("jdbc:mysql://0.0.0.0:3306/nomebanco?autoReconnect=true&useSSL=false");
        //usuário utilizado em um container MySQL
        this.datasource.setUsername("root");
        // senha padrao utilizada no container MySQL
        this.datasource.setPassword("urubu100");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }

}
