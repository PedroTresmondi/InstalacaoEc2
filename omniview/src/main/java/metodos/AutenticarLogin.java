package metodos;

import com.mycompany.omniview.Connection;
import com.mycompany.omniview.ConnectionMysql;
import java.util.List;
import javaswing.TelaLogin;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import user.User;

public class AutenticarLogin {

    private String email;
    private String senha;
    private String id;
    public Integer FkEstt;
    private boolean userAutenticado = false;

    ConnectionMysql configMySQL = new ConnectionMysql();
    JdbcTemplate conSQL = new JdbcTemplate(configMySQL.getDataSourceSQL());

    public boolean isUserAutenticado() {
        return userAutenticado;
    }

    public void setUserAutenticado(boolean userAutenticado) {
        this.userAutenticado = userAutenticado;
    }

    public AutenticarLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public AutenticarLogin() {
    }

    public String getEmail() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List emailUsuariosBanco = con.queryForList("SELECT EMAIL FROM "
                + "USUARIO WHERE EMAIL = ?", email);

        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");

    }

    public String getSenha() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIO WHERE SENHA = ?", senha);
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public String getId() {
        return this.id;
    }

    public static void AbrirLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }

        });

    }

    public void AutenticarLogin(String email, String senha,
            String emailUsuarioBanco, String senhaUsuarioBanco) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        metodos.RecursosComputador regMaq = new RecursosComputador();
        metodos.MedicoesComputador medMaq = new MedicoesComputador();
        metodos.ConsultaBanco cnstBanco = new ConsultaBanco();

        metodos.Log log = new Log();

        List<User> usuario = con.query("SELECT EMAIL, SENHA FROM USUARIO "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Acesso negado \n Usuário ou "
                    + "senha incorretos");

        } else {
            setUserAutenticado(true);
            regMaq.getHostname();
            this.email = emailUsuarioBanco;
            cnstBanco.getFKEst(email);
            JOptionPane.showMessageDialog(null, "Usuario Autenticado");

            //cnstBanco.getFKEst(emailFK.getEmail());
            regMaq.inserirMaquinas(cnstBanco.getFKEst(email));
            medMaq.inserirMedicao();
            FkEstt = cnstBanco.getFKEst(email);
            log.gerarLog();

        }

    }

    public void RegistrarCaixa(java.awt.event.ActionEvent evt,
            Boolean checkCaixa) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        metodos.ConsultaBanco cnstBanco = new ConsultaBanco();

        if (userAutenticado == true) {
            if (checkCaixa == true) {
                JOptionPane.showMessageDialog(null, "Você cadastrou um Caixa!");

                con.update("UPDATE MAQUINA SET TIPO='C' WHERE ID = ?", cnstBanco.getIDMaquinaAzure());
                List updateMaqAzure = con.queryForList("SELECT * FROM "
                        + "MAQUINA  WHERE ID =?", cnstBanco.getIDMaquinaAzure());
                updateMaqAzure.get(0).toString().replace("{EMAIL=", "").replace("}", "");
                System.out.println(updateMaqAzure);
                System.out.println("Caixa cadastrado na AZURE ID: "
                        + cnstBanco.getIDMaquinaSQL());

                conSQL.update("UPDATE MAQUINA SET TIPO='C' WHERE ID = ?", cnstBanco.getIDMaquinaAzure());
                List updateMaqSQL = con.queryForList("SELECT * FROM "
                        + "MAQUINA  WHERE ID =?", cnstBanco.getIDMaquinaSQL());
                updateMaqSQL.get(0).toString().replace("{EMAIL=", "").replace("}", "");
                System.out.println(updateMaqSQL);
                System.out.println("Caixa cadastrado no MYSQL ID: "
                        + cnstBanco.getIDMaquinaSQL());

            } else {
                System.out.println("caixa nao cadastrado");
            }

        }
    }

    public void RegistrarTotem(java.awt.event.ActionEvent evt,
            Boolean checkTotem) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        metodos.ConsultaBanco cnstBanco = new ConsultaBanco();

        if (userAutenticado == true) {
            if (checkTotem = true) {
                JOptionPane.showMessageDialog(null, "Você cadastrou um Totem!");
                con.update("UPDATE MAQUINA SET TIPO='T' WHERE ID = ?", cnstBanco.getIDMaquinaAzure());
                List updateMaqAzure = con.queryForList("SELECT * FROM "
                        + "MAQUINA WHERE ID = ?", cnstBanco.getIDMaquinaAzure());
                updateMaqAzure.get(0).toString().replace("{EMAIL=", "").replace("}", "");
                System.out.println(updateMaqAzure);
                System.out.println("Totem cadastrado na AZURE ID: "
                        + cnstBanco.getIDMaquinaAzure());
                System.out.println(updateMaqAzure);

                conSQL.update("UPDATE MAQUINA SET TIPO='T' WHERE ID = ?", cnstBanco.getIDMaquinaAzure());
                List updateMaqSQL = con.queryForList("SELECT * FROM "
                        + "MAQUINA WHERE ID = ?", cnstBanco.getIDMaquinaSQL());
                updateMaqSQL.get(0).toString().replace("{EMAIL=", "").replace("}", "");
                System.out.println("Totem cadastrado no SQL ID: "
                        + cnstBanco.getIDMaquinaSQL());
                System.out.println(updateMaqSQL);

            } else {
                System.out.println("totem nao cadastrado");
            }

        }

    }

}
