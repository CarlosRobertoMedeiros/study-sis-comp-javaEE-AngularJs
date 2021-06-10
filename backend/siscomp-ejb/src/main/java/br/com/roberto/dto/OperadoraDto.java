package br.com.roberto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codigoOperadora",
        "nomeOperadora",
        "tipoOperadora"
})
public class OperadoraDto {

    @EqualsAndHashCode.Include
    @JsonProperty("codigoOperadora")
    private Long codigoOperadora;

    @JsonProperty("nomeOperadora")
    private String nomeOperadora;

    @JsonProperty("tipoOperadora")
    private String tipoOperadora;
}
