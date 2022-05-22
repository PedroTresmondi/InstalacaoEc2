/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview;

import metodos.Log;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author pedro
 */
public class ConnectionMysql {

    private BasicDataSource dataSource;

    Log log = new Log();

    public ConnectionMysql() {
        try {
            this.dataSource = new BasicDataSource();

            this.dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

            this.dataSource.setUrl("jdbc:mysql://localhost:3306/omniview?useTimezone-true&serverTimezone-UTC");

            this.dataSource.setUsername("root");
            this.dataSource.setPassword("root");

        } catch (Exception e) {
            System.out.println("erro");
        }
    }

}
