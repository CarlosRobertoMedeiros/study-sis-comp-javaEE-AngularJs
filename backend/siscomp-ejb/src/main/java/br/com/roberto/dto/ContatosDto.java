package br.com.roberto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ContatosDto {

    @JsonProperty("contatos")
    private List<ContatoDto> contatos;

    @JsonIgnore
    public List<ContatoDto> getContatos() {
        return this.contatos;
    }

//    public ContatosDto(List<ContatoDto> contatos) {
//        this.contatos = contatos;
//    }

    @JsonIgnore
    public void setContatos(List<ContatoDto> contatos) {
        this.contatos = contatos;
    }
}
