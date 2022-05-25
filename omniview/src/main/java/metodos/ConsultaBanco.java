/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import com.mycompany.omniview.Connection;
import com.mycompany.omniview.ConnectionMysql;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class ConsultaBanco {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    AutenticarLogin al = new AutenticarLogin();

    ConnectionMysql configMySQL = new ConnectionMysql();
    JdbcTemplate conSQL = new JdbcTemplate(configMySQL.getDataSourceSQL());
    
    metodos.RecursosComputador reqMaq = new RecursosComputador();
    public String idMaqBancoString = getIDMaquina();

    //Consulta FKEstUser da tabela Usuario AZURE
    public Integer getFKEst(String email) {
        return con.queryForObject("SELECT FK_EstUser FROM USUARIO WHERE email = ? ",
                Integer.class, email);
    }

    public String getIDMaquina() {
        List IdMaqBanco = con.queryForList("select ID from Maquina WHERE hostName = ? ORDER BY id DESC",
                reqMaq.getHostname());
        return IdMaqBanco.get(0).toString().replace("{ID=", "").replace("}", "");
    }

    //Consulta IDMAQUINA da tabela Usuario SQL DOCKER
    public String getIDMaquinaSQL() {
        List IdMaqBancoSQL = conSQL.queryForList("select ID from maquina WHERE hostName = ? ORDER BY id DESC",
                reqMaq.getHostname());
        return IdMaqBancoSQL.get(0).toString().replace("{ID=", "").replace("}", "");
    }

}
