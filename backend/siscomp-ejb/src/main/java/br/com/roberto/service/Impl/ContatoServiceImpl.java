package br.com.roberto.service.Impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.Paginacao;
import br.com.roberto.service.ContatoService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContatoServiceImpl implements ContatoService, Serializable {

    @Inject
    private ContatoRepository contatoRepository;

    @Override
    public List<ContatoDto> getContatos() throws NegocioException {
        List<Contato> contatos = contatoRepository.findAll();
        List<ContatoDto> contatoDtos;
        contatoDtos = tratarContatoResponse(contatos);
        return contatoDtos;
    }

    @Override
    public List<ContatoDto> getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual) {
        List<Contato> contatos =  contatoRepository.listaTodosContatosPaginados(totalRegistrosPorPagina, paginaAtual);
        List<ContatoDto> contatoDtos;
        contatoDtos = tratarContatoResponse(contatos);
        return contatoDtos;
    }

    private List<ContatoDto> tratarContatoResponse(List<Contato> contatos) {
        List<ContatoDto> contatoDtos = new ArrayList<>();

        for (Contato contato: contatos) {
            ContatoDto contatoDto = new ContatoDto();

            //Campos interessantes a serem expostos
            contatoDto.setId(contato.getId());
            contatoDto.setCpf(contato.getCpf());
            contatoDto.setNome(contato.getNome());
            contatoDto.setTelefone(contato.getTelefone());
            //contatoDto.setDataUltimaAtualizacao(contato.getDataUltimaAtualizacao());
            contatoDtos.add(contatoDto);
        }
        return contatoDtos;
    }
}
