package br.com.roberto.service.Impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.service.ContatoService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ContatoServiceImpl implements ContatoService {

    @Inject
    private ContatoRepository contatoRepository;

    @Override
    public List<ContatoDto> getContatos() {
        List<Contato> contatos = contatoRepository.findAll();

        //todo:Falta Implementar um Método para Converter a lista de Contatos para o seu devido DTO


        return null;
    }
}
