package br.com.roberto.dto;

import br.com.roberto.entity.Operadora;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idContato",
        "nome",
        "telefone",
        "dataUltimaAtualizacao",
        "operadora"
})
public class ContatoDto {

    @EqualsAndHashCode.Include
    @JsonProperty("idContato")
    private Long idContato;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("dataUltimaAtualizacao")
    private LocalDate dataUltimaAtualizacao;

    @JsonProperty("operadora")
    private Operadora operadora;

}
