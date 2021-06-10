package br.com.roberto.v1.model.input;

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
public class OperadoraInput {

    @ApiModelProperty(value = "Código da Operadora", required = true, example = "14")
    private Long codigoOperadora;
    @ApiModelProperty(value = "Nome da Operadora", required = true, example = "Oi")
    private String nomeOperadora;
    @ApiModelProperty(value = "Tipo da Operadora", required = true, example = "F -> Fixo / C -> Celular")
    private String tipoOperadora;
}
