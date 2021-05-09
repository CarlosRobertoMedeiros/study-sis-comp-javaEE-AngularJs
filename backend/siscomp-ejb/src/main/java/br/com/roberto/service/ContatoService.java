package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.ContatosPaginadosDto;

import javax.ejb.Local;

@Local
public interface ContatoService {
    ContatosDto getContatos();
    ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual);
    ContatoDto getContatosById(Long id);
    ContatoDto insereContato(ContatoDto contatoDto);
    ContatoDto atualizaContato(Long id, ContatoDto converterContatoDto);
    void excluiContatoById(Long id);
}
