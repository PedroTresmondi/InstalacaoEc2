/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import user.User;

public class Log {

    public void gerarLog() {
        metodos.RecursosComputador recMaq = new RecursosComputador();
        
       
        File arquvoLog = new File("logAplicacao.txt");
        try {
            if (arquvoLog.exists() == false) {
                System.out.println("Criando novo Arquivo log");
                arquvoLog.createNewFile();
            }
            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            PrintWriter out = new PrintWriter(arquvoLog);
            out.append("Maquina " + recMaq.getHostname() + " Registrada em: " + dataDeHoje.toString() + "\n");
            out.append("login sucedido ");
            out.close();
        } catch (IOException e) {
            System.out.println("Nao foi possivel criar o log!");
        }
    }
}
