package br.com.roberto.v1.configuracoes.mensagens;

import java.util.ResourceBundle;

public class ConfiguracaoMensagens {

    private static ResourceBundle rb = ResourceBundle.getBundle("messages");

    public static void main(String[] args) {
        String browser = rb.getString("browser");
        System.out.println(browser);
    }

}
