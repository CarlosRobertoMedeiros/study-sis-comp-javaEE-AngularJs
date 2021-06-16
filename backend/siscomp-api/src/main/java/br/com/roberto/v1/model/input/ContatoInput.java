package br.com.roberto.v1.model.input;

import br.com.roberto.entity.Operadora;
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
public class ContatoInput {

    @ApiModelProperty(value = "Nome do Contato", required = true, example = "Antonio Nunes")
    private String nome;

    @ApiModelProperty(value = "Telefone do Contato", required = true , example = "(99)9999-9999")
    private String telefone;

    @ApiModelProperty(value = "Data de Nascimento", required = true , example = "2021-07-24T03:00:00.000Z - ISO8601")
    private String dataNascimento;

    @ApiModelProperty(value = "Código Operadora", required = true , example = "14")
    private OperadoraInput operadora;

}
