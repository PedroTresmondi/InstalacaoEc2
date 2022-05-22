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

    public void sucesso() {
        metodos.AutenticarLogin login = new AutenticarLogin();
        metodos.RecursosComputador recMaq = new RecursosComputador();
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());

        String maquina = recMaq.getHostname();
        String user = login.getEmail();

        File arquvoLog = new File("logAplicacao.txt");
        try {
            if (arquvoLog.exists() == false) {
                System.out.println("Criando novo Arquivo log");
                arquvoLog.createNewFile();
            }
            PrintWriter out = new PrintWriter(arquvoLog);
            out.append("Maquina " + maquina + " Registrada em: " + dataDeHoje + "\n");
            out.append(user + "logado em " + dataDeHoje);
            out.close();

            out.close();
        } catch (IOException e) {
            System.out.println("Nao foi possivel criar o log!");
        }
    }

}
