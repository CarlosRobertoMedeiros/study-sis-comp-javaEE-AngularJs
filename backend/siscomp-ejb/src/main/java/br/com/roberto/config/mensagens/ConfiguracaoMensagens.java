package br.com.roberto.config.mensagens;

import java.util.ResourceBundle;

public class ConfiguracaoMensagens {

    //TODO:VERIFICAR A NECESSIDADA DE CENTRALIZAÇÃO NO FUTURO
    private static ResourceBundle rb = ResourceBundle.getBundle("messages-negocio_PT-BR");

    public static void main(String[] args) {
        System.out.println(rb.getString("username"));
    }

}
