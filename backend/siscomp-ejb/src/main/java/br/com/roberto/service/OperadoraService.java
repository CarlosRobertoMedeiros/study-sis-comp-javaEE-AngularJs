package br.com.roberto.service;

import br.com.roberto.dto.OperadorasDto;

import javax.ejb.Local;

@Local
public interface OperadoraService {
    OperadorasDto getOperadoras();
}
