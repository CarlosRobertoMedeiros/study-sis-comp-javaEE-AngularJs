package br.com.roberto.dto;

import br.com.roberto.entity.Contato;
import br.com.roberto.repository.Paginacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatosPaginadosDto {

    @JsonProperty("contatos")
    private List<br.com.roberto.dto.ContatoDto> contatoDtos;

    @JsonProperty("totalizador")
    private Paginacao<Contato> totalizadorContatoDto;

    public ContatosPaginadosDto(List<br.com.roberto.dto.ContatoDto> contatoDtos, Paginacao<Contato> totalizadorContatoDto) {
        this.contatoDtos = contatoDtos;
        this.totalizadorContatoDto = totalizadorContatoDto;
    }

    @JsonIgnore
    public Paginacao<Contato> getContatoPaginado() {
        return totalizadorContatoDto;
    }

    @JsonIgnore
    public List<br.com.roberto.dto.ContatoDto> getContatoDtos(){
        return contatoDtos;
    }


}
