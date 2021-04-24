package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.exceptions.InfraEstruturaException;
import br.com.roberto.exceptions.NegocioException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContatoService {
    List<ContatoDto> getContatos() throws NegocioException, InfraEstruturaException;
    ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual) throws NegocioException, InfraEstruturaException;
    ContatoDto getContatosById(Long id) throws NegocioException, InfraEstruturaException;
    ContatoDto insereContato(ContatoDto contatoDto) throws NegocioException, InfraEstruturaException;
    ContatoDto atualizaContato(Long id, ContatoDto converterContatoDto) throws NegocioException, InfraEstruturaException;
    void excluiContatoById(Long id) throws NegocioException, InfraEstruturaException;

}
