package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;

import java.util.List;

public interface ContatoServiceTest {

    List<ContatoDto> getContatos();
    ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual);
    ContatoDto getContatosById(Long id);
    ContatoDto insereContato(ContatoDto contatoDto);
    ContatoDto atualizaContato(Long id, ContatoDto converterContatoDto);
    void excluiContatoById(Long id);

}
