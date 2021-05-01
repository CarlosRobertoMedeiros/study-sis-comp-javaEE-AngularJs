package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContatoService {
    List<ContatoDto> getContatos();
    ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual);
    ContatoDto getContatosById(Long id);
    ContatoDto insereContato(ContatoDto contatoDto);
    ContatoDto atualizaContato(Long id, ContatoDto converterContatoDto);
    void excluiContatoById(Long id);
    int somar(int a, int b);

}
