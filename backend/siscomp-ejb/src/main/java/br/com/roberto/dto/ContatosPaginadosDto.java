package br.com.roberto.dto;

import br.com.roberto.entity.Contato;
import br.com.roberto.repository.Paginacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatosPaginadosDto {

    @JsonProperty("contatosDto")
    private List<ContatoDto> contatoDtos;
    @JsonProperty("totalizadorContatoDto")
    private Paginacao<Contato> totalizadorContatoDto;

    public ContatosPaginadosDto(List<ContatoDto> contatoDtos, Paginacao<Contato> totalizadorContatoDto) {
        this.contatoDtos = contatoDtos;
        this.totalizadorContatoDto = totalizadorContatoDto;
    }

    public Paginacao<Contato> getContatoPaginado() {
        return totalizadorContatoDto;
    }

    public void setContatoPaginado(Paginacao<Contato> contatoPaginado) {
        this.totalizadorContatoDto = contatoPaginado;
    }

    public List<ContatoDto> getContatoDtos() {
        return contatoDtos;
    }

    public void setContatoDtos(List<ContatoDto> contatoDtos) {
        this.contatoDtos = contatoDtos;
    }
}
