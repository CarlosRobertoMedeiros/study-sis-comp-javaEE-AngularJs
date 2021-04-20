package br.com.roberto.service.Impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosPaginadosDto;
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
    public ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual) {

        //IllegalArgumentException
        List<Contato> contatos = new ArrayList<>();
        try{
            contatos= contatoRepository.listaTodosContatosPaginados(totalRegistrosPorPagina, paginaAtual);
            List<ContatoDto> contatoDtos;
            contatoDtos = tratarContatoResponse(contatos);
            return new ContatosPaginadosDto(contatoDtos,contatoRepository.findAllWithPagination(totalRegistrosPorPagina, paginaAtual));
        }catch (IllegalArgumentException ie){
            System.out.println("Erro =>" + ie);
        }catch (Exception ex ){
            System.out.println("Exception =>" + ex);
        }
        return null;
    }

    private List<ContatoDto> tratarContatoResponse(List<Contato> contatos) {
        List<ContatoDto> contatoDtos = new ArrayList<>();

        for (Contato contato: contatos) {
            ContatoDto contatoDto = new ContatoDto();

            //Campos interessantes a serem expostos
            contatoDto.setIdContato(contato.getId());
            contatoDto.setCpf(contato.getCpf());
            contatoDto.setNome(contato.getNome());
            contatoDto.setTelefone(contato.getTelefone());
            //contatoDto.setDataUltimaAtualizacao(contato.getDataUltimaAtualizacao());
            contatoDtos.add(contatoDto);
        }
        return contatoDtos;
    }
}
