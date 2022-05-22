package metodos;

import com.mycompany.omniview.Connection;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class IntegracaoSlack {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    metodos.RecursosComputador reqMaq = new RecursosComputador();
    
    public String verificarEmpresa(){
        
        List IdMaqBanco = con.queryForList("select Fk_EstMaq from Maquina where hostName = ? ORDER BY ID DESC",
        reqMaq.getHostname());
        String fkVar = String.valueOf(IdMaqBanco.get(0)).replace("Fk_EstMaq=", "");
        
       return fkVar;
        
        
        
//        switch (fkEst) {
//                    case 1:
//                      getEnviaAlertas(tipoAlerta, corAlerta, hostName, tipoMedicao, Double.NaN);
//                        break;
//                    default:                       getEnviaAlertasc(tipoAlerta, corAlerta, hostName, tipoMedicao, Double.NaN);
//                        throw new AssertionError();
//                }
//        return fkEst;
    }
    
    public static void getEnviaAlertasCmMikeys(String tipoAlerta,String corAlerta,String hostName,String tipoMedicao, Double ramEmUso) throws Exception {

        String msgAlerta = String.format("%s %s\n"
                + "Máquina: %s\n"
                + "%s Disponivel: %.2f GB",
                tipoAlerta,corAlerta,hostName,tipoMedicao,ramEmUso);

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods("xoxb-3467541436532-3524285250806-629WCz0SeqqFFZ953Vf9xhVi");

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#cm-mikeys") // Use a channel ID `C1234567` is preferrable
                .text(msgAlerta)
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        System.out.println(response);
        System.out.println(response.getError());
    }
    
     public static void getEnviaAlertasBurgerqueen (String tipoAlerta,String corAlerta,String hostName,String tipoMedicao, Double ramEmUso) throws Exception {

        String msgAlerta = String.format("%s %s\n"
                + "Máquina: %s\n"
                + "%s Disponivel: %.2f GB",
                tipoAlerta,corAlerta,hostName,tipoMedicao,ramEmUso);

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods("xoxb-3467541436532-3524285250806-629WCz0SeqqFFZ953Vf9xhVi");

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#burgerqueen") // Use a channel ID `C1234567` is preferrable
                .text(msgAlerta)
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        System.out.println(response);
        System.out.println(response.getError());
    }
}
