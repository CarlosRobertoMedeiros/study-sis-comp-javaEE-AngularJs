package br.com.roberto.config.mensagens;

import java.util.ResourceBundle;

public class ConfiguracaoMensagens {

    //Pegar as seguinte referências: https://www.youtube.com/watch?v=1wEp9yHHtwg
    //TODO: Implementar Corretamente no futuro
    private static ResourceBundle rb = ResourceBundle.getBundle("src/main/resource/messages.properties");

    public static void main(String[] args) {
        String browser = rb.getString("browser");
        System.out.println(browser);
    }

}
