package br.com.roberto.service.impl;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.Paginacao;
import br.com.roberto.service.ContatoService;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContatoServiceImpl implements ContatoService, Serializable {

    @Inject
    private ContatoRepository contatoRepository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ContatoDto> getContatos(){
        List<Contato> contatos = null;
        List<ContatoDto> contatosResponse = null;
        try{
            contatos = contatoRepository.findAll();
            contatosResponse = tratarContatoResponse(contatos);
            ContatosDto contatosDto = new ContatosDto();
            contatosDto.setContatos(contatosResponse);
            return contatosDto.getContatos();
        }catch (Exception e){
            throw new NegocioException("Erro ao retornar os dados dos contatos ");
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual){

        List<Contato> contatos = new ArrayList<>();
        List<ContatoDto> contatosResponse;
        Paginacao<Contato> dadosPaginados = null;
        try {
            contatos = contatoRepository.listaTodosContatosPaginados(totalRegistrosPorPagina, paginaAtual);
            contatosResponse = tratarContatoResponse(contatos);
            dadosPaginados = contatoRepository.findAllWithPagination(totalRegistrosPorPagina, paginaAtual);
            return  new ContatosPaginadosDto(contatosResponse, dadosPaginados);
        }catch (Exception e){
            throw new NegocioException("Erro ao retornar os dados paginados de contatos");
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ContatoDto getContatosById(Long id){
        Contato contato = null;
        ContatoDto contatoResponse = null;

        contato = contatoRepository.findById(id);

        if (contato.getIdContato()==null){
            throw new NegocioException("O Contato é Obrigatório");
        }
        contatoResponse = converterContatoResponse(contato);
        return contatoResponse;

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ContatoDto insereContato(ContatoDto contatoDto) {
        Contato contato = null;
        ContatoDto contatoResponse = null;

        contato = converterContatoDTO(contatoDto);
        if (contato.getCpf()==null){
            throw new NegocioException("O Cpf é Obrigatório");
        }
        contatoRepository.persist(contato);
        contatoResponse = converterContatoResponse(contato);
        return contatoResponse;

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ContatoDto atualizaContato(Long id, ContatoDto novoContatoDTO) {
        Contato contato = null;
        Contato contatoAtualizado = null;

        contato = contatoRepository.findById(id);
        if (contato == null) {
            throw new NegocioException("O Contato informado é inexistente");
        }
        contatoAtualizado = converterContatoDTO(novoContatoDTO);

        contato.setCpf(contatoAtualizado.getCpf());
        contato.setNome(contatoAtualizado.getNome());
        contato.setTelefone(contatoAtualizado.getTelefone());

        contatoRepository.merge(contato);
        return converterContatoResponse(contato);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excluiContatoById(Long id) {

        Contato contato = contatoRepository.findById(id);
        if (contato==null){
            throw new NegocioException(" O Contato informado é inexistente");
        }
        contatoRepository.remove(contato);
    }

    private Contato converterContatoDTO(ContatoDto contatoDto) {
        Contato contato = new Contato();

        try {
            BeanUtils.copyProperties(contato, contatoDto);
        } catch (IllegalAccessException | InvocationTargetException e){
            throw new NegocioException("Problema na conversão interna das mensagens",e);
        }
        return contato;
    }

    private ContatoDto converterContatoResponse(Contato contato) {
        ContatoDto contatoResponse = new ContatoDto();

        try {
            BeanUtils.copyProperties(contatoResponse, contato);
        } catch (IllegalAccessException | InvocationTargetException e){
            throw new NegocioException("Problema na conversão interna das mensagens",e);
        }
        return contatoResponse;

    }

    private List<ContatoDto> tratarContatoResponse(List<Contato> contatos){
        List<ContatoDto> contatosDto = new ArrayList<>();


        for (Contato contato: contatos) {
            ContatoDto contatoDto = new ContatoDto();

            try {
                BeanUtils.copyProperties(contatoDto, contato);
            } catch (IllegalAccessException | InvocationTargetException e){
                throw new NegocioException("Problema na conversão interna das mensagens",e);
            }
            contatosDto.add(contatoDto);
        }

        return contatosDto;
    }
}
/*
Todo:
    - Solução Backend
         - Implementar solução JWT usando KeyCloack -- Após o frontEnd

    - Solução FrontEnd
        - Implementar o Front End
 */


//
//
