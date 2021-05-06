package br.com.roberto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contatos"
})
public class ContatosDto {

    @JsonProperty("contatos")
    private List<ContatoDto> contatoDtos = null;

    public ContatosDto(List<ContatoDto> contatoDtos) {
        this.contatoDtos = contatoDtos;
    }

    @JsonProperty("contatos")
    public List<ContatoDto> getContatoDtos(){
        return this.contatoDtos;
    }

}
