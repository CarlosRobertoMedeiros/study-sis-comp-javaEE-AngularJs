package br.com.roberto.service.Impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.InfraEstruturaException;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.Paginacao;
import br.com.roberto.service.ContatoService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
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
        List<Contato> contatos = null;
        List<ContatoDto> contatosResponse = null;
        try{
            contatos = contatoRepository.findAll();
            contatosResponse = tratarContatoResponse(contatos);
            return contatosResponse;
        }catch (Exception e){
            throw new NegocioException("Erro ao retornar os dados dos contatos ");
        }
    }

    @Override
    public ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual) throws NegocioException, InfraEstruturaException {

        List<Contato> contatos = new ArrayList<>();
        List<ContatoDto> contatosResponse;
        Paginacao<Contato> dadosPaginados = null;
        try {
            contatos = contatoRepository.listaTodosContatosPaginados(totalRegistrosPorPagina, paginaAtual);
            contatosResponse = tratarContatoResponse(contatos);
            dadosPaginados = contatoRepository.findAllWithPagination(totalRegistrosPorPagina, paginaAtual);
            return new ContatosPaginadosDto(contatosResponse, dadosPaginados);
        }catch (Exception e){
            throw new NegocioException("Erro ao retornar os dados paginados de contatos");
        }
    }

    private List<ContatoDto> tratarContatoResponse(List<Contato> contatos) {
        List<ContatoDto> contatosDto = new ArrayList<>();

        for (Contato contato: contatos) {
            ContatoDto contatoDto = new ContatoDto();

            //Campos interessantes a serem expostos
            contatoDto.setIdContato(contato.getId());
            contatoDto.setCpf(contato.getCpf());
            contatoDto.setNome(contato.getNome());
            contatoDto.setTelefone(contato.getTelefone());
            //contatoDto.setDataUltimaAtualizacao(contato.getDataUltimaAtualizacao());
            contatosDto.add(contatoDto);
        }
        return contatosDto;
    }
}
