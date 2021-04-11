package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContatoService {
    List<ContatoDto> getContatos();
}
