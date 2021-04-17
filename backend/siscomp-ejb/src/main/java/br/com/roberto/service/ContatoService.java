package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.exceptions.NegocioException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContatoService {
    List<ContatoDto> getContatos() throws NegocioException;
    List<ContatoDto> getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual);
}
