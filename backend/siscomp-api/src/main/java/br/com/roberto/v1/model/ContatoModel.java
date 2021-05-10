package br.com.roberto.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatoModel {

    @ApiModelProperty(value = "Id do Contato", required = true, example = "1")
    private Long id;
    @ApiModelProperty(value = "CPF do Contato", required = true , example = "111.111.111-11")
    private String cpf;
    @ApiModelProperty(value = "Nome do Contato", required = true, example = "Antonio Nunes")
    private String nome;
    @ApiModelProperty(value = "Telefone do Contato", required = true , example = "(99)9999-9999")
    private String telefone;
    //private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    public ContatoModel(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }
}
