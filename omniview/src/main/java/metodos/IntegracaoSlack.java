package metodos;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

public class IntegracaoSlack {
    public static void getEnviaAlertas(String tipoAlerta,String corAlerta,String hostName,String tipoMedicao, Double ramEmUso) throws Exception {

        String msgAlerta = String.format("%s %s\n"
                + "Máquina: %s\n"
                + "%s Disponivel: %.2f GB",
                tipoAlerta,corAlerta,hostName,tipoMedicao,ramEmUso);

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods("xoxb-3467541436532-3524285250806-400eERHbXNHhCdm2iOQdaZup");

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#geral") // Use a channel ID `C1234567` is preferrable
                .text(msgAlerta)
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        System.out.println(response);
        System.out.println(response.getError());
    }
}
