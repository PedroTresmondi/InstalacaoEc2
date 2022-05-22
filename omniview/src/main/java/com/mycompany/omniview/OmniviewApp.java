package com.mycompany.omniview;

import metodos.IntegracaoSlack;

public class OmniviewApp {

    public static void main(String[] args) {
        
        metodos.AutenticarLogin.AbrirLogin();
        IntegracaoSlack fk = new IntegracaoSlack();
        System.out.println(fk.consultaEmpresa());
       fk.enviaAlerta(fk.consultaEmpresa());
        
    }

}
