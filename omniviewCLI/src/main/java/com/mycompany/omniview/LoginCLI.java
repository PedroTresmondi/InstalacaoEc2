package com.mycompany.omniview;

import java.util.Scanner;
import metodos.AutenticarLogin;
import user.User;

public class LoginCLI {

    public static void main(String[] args) {
        metodos.AutenticarLogin login = new AutenticarLogin();
        Scanner leitor = new Scanner(System.in);
        System.out.println("            
 System.out.println("$$$$$$\\                          $$\\            $$\\  ");                       
$$  __$$\                         \__|           \__|                        
$$ /  $$ |$$$$$$\$$$$\  $$$$$$$\  $$\ $$\    $$\ $$\  $$$$$$\  $$\  $$\  $$\ 
$$ |  $$ |$$  _$$  _$$\ $$  __$$\ $$ |\$$\  $$  |$$ |$$  __$$\ $$ | $$ | $$ |
$$ |  $$ |$$ / $$ / $$ |$$ |  $$ |$$ | \$$\$$  / $$ |$$$$$$$$ |$$ | $$ | $$ |
$$ |  $$ |$$ | $$ | $$ |$$ |  $$ |$$ |  \$$$  /  $$ |$$   ____|$$ | $$ | $$ |
 $$$$$$  |$$ | $$ | $$ |$$ |  $$ |$$ |   \$  /   $$ |\$$$$$$$\ \$$$$$\$$$$  |
 \______/ \__| \__| \__|\__|  \__|\__|    \_/    \__| \_______| \_____\____/ ");
        System.out.println("Digite o email cadastrado");
        String email = leitor.nextLine();
        System.out.println("Digite a senha cadastrada");
        String senha = leitor.nextLine();
        User usuario = new User(01, email, senha);
        login.AutenticarLogin(email, senha, usuario.getEmail(), usuario.getSenha());
        

    }
}
