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

    @Override
    public ContatoDto getContatosById(Long id) throws NegocioException, InfraEstruturaException {
        Contato contato = null;
        ContatoDto contatoResponse = null;

        contato = contatoRepository.findById(id);

        if (contato.getId()==null){
            throw new NegocioException("O Contato é Obrigatório");
        }
        contatoResponse = converterContatoResponse(contato);
        return contatoResponse;

    }

    @Override
    public ContatoDto insereContato(ContatoDto contatoDto) throws NegocioException, InfraEstruturaException {
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
    public ContatoDto atualizaContato(Long id, ContatoDto novoContatoDTO) throws NegocioException, InfraEstruturaException {
        Contato contato = null;
        Contato contatoAtualizado = null;

        contato = contatoRepository.findById(id);
        if (contato == null) {
            throw new NegocioException(" O Contato informado é inexistente");
        }
        contatoAtualizado = converterContatoDTO(novoContatoDTO);

        contato.setCpf(contatoAtualizado.getCpf());
        contato.setNome(contatoAtualizado.getNome());
        contato.setTelefone(contatoAtualizado.getTelefone());

        contatoRepository.merge(contato);
        return converterContatoResponse(contato);
    }

    @Override
    public void excluiContatoById(Long id) throws NegocioException, InfraEstruturaException {

        Contato contato = contatoRepository.findById(id);
        if (contato==null){
            throw new NegocioException(" O Contato informado é inexistente");
        }
        contatoRepository.remove(contato);
    }

    private Contato converterContatoDTO(ContatoDto contatoDto) {
        Contato contato = new Contato();
        contato.setNome(contatoDto.getNome());
        contato.setTelefone(contatoDto.getTelefone());
        contato.setCpf(contatoDto.getCpf());
        return contato;

    }

    private ContatoDto converterContatoResponse(Contato contato) {
        ContatoDto contatoResponse = new ContatoDto();

        contatoResponse.setIdContato(contato.getId());
        contatoResponse.setNome(contato.getNome());
        contatoResponse.setTelefone(contato.getTelefone());
        contatoResponse.setCpf(contato.getCpf());
        return contatoResponse;

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
/*
Todo:
    - Solução Backend
         - Implementar as classes de ExceptionMapper e WebApplicationException
         - Tentar respeitar a segregação de dependências
         - No pacote de negócios a consulta por id que deve chamar as outras camadas
         - Implementar os testes com mock das camandas
         - Criar um ambiente de teste caixa branca - Teste Unitário
         - Implementar solução JWT usando KeyCloack

    - Solução FrontEnd
        - Implementar o Front End
 */


//
//
