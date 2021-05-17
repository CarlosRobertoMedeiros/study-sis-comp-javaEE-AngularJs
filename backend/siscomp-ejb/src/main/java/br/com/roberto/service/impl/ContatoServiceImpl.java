package br.com.roberto.service.impl;

import br.com.roberto.conversores.negocio.ContatoDtoParaContato;
import br.com.roberto.conversores.negocio.ContatoParaContatoDto;
import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.ContatosPaginadosDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.ContatoRepository;
import br.com.roberto.repository.Paginacao;
import br.com.roberto.service.ContatoService;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContatoServiceImpl implements ContatoService, Serializable {

    private static ResourceBundle rb = ResourceBundle.getBundle("messages-negocio_PT-BR");

    @Inject
    private ContatoRepository contatoRepository;

    /**
     * Método do BeanEJB Responsável por listar todos os contatos
     * Essa funcionalidade vai ser depreciada
     * @return ContatosDto
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ContatosDto getContatos(){
        List<Contato> contatos = null;
        List<ContatoDto> contatosResponse = null;
        try{
            contatos = contatoRepository.findAll();
            contatosResponse = ContatoParaContatoDto.toCollectionDtoObject(contatos);
            ContatosDto contatosDto = new ContatosDto();
            contatosDto.setContatos(contatosResponse);
            return contatosDto;
        }catch (Exception e){
            throw new NegocioException(rb.getString("CONTATOS_NAO_ENCONTRADOS"));
        }
    }

    /**
     * Método do BeanEJB Responsável por listar todos os contatos
     * de maneira paginada
     * @return ContatosPaginadosDto
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ContatosPaginadosDto getContatosPaginados(int totalRegistrosPorPagina, int paginaAtual){

        List<Contato> contatos = new ArrayList<>();
        List<ContatoDto> contatosResponse;
        Paginacao<Contato> dadosPaginados = null;
        try {
            contatos = contatoRepository.listaTodosContatosPaginados(totalRegistrosPorPagina, paginaAtual);
            contatosResponse = ContatoParaContatoDto.toCollectionDtoObject(contatos);
            dadosPaginados = contatoRepository.findAllWithPagination(totalRegistrosPorPagina, paginaAtual);
            return  new ContatosPaginadosDto(contatosResponse, dadosPaginados);
        }catch (Exception e){
            throw new NegocioException(rb.getString("CONTATOS_PAGINADOS_NAO_ENCONTRADOS"));
        }
    }

    /**
     * Método do BeanEJB Responsável por listar os dados do contato por Id
     * @return ContatosPaginadosDto
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ContatoDto getContatosById(Long id){
        Contato contato = null;
        ContatoDto contatoResponse = null;

        contato = contatoRepository.findById(id);

        if (contato==null){
            throw new NegocioException(rb.getString("CONTATO_OBRIGATORIO"));
        }
        contatoResponse = ContatoParaContatoDto.toDtoObject(contato);
        return contatoResponse;
    }

    /**
     * Método do BeanEJB Responsável por Inserir os dados de um contato
     * @return ContatoDto
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ContatoDto insereContato(ContatoDto contatoDto) {
        Contato contato = null;
        ContatoDto contatoResponse = null;

        contato = ContatoDtoParaContato.toDto(contatoDto);
        if (contato==null){
            throw new NegocioException(rb.getString("CPF_OBRIGATORIO"));
        }
        contatoRepository.persist(contato);
        contatoResponse = ContatoParaContatoDto.toDtoObject(contato);
        return contatoResponse;
    }

    /**
     * Método do BeanEJB Responsável por atualizar os dados de um contato
     * @param id
     * @param novoContatoDTO
     * @return ContatoDto
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ContatoDto atualizaContato(Long id,ContatoDto novoContatoDTO) {
        Contato contato = null;
        Contato contatoAtualizado = null;

        contato = contatoRepository.findById(id);
        if (contato == null) {
            throw new NegocioException(rb.getString("CONTATO_INFORMADO_INEXISTENTE"));
        }
        contatoAtualizado = ContatoDtoParaContato.toDto(novoContatoDTO);

        contato.setCpf(contatoAtualizado.getCpf());
        contato.setNome(contatoAtualizado.getNome());
        contato.setTelefone(contatoAtualizado.getTelefone());

        contatoRepository.merge(contato);
        return ContatoParaContatoDto.toDtoObject(contato);
    }

    /**
     * Método do BeanEJB Responsável por excluir um contato
     * @param id
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excluiContatoById(Long id) {

        Contato contato = contatoRepository.findById(id);
        if (contato==null){
            throw new NegocioException(rb.getString("CONTATO_INFORMADO_INEXISTENTE"));
        }
        contatoRepository.remove(contato);
    }
}
/*
Todo:
    - Solução Backend
         - Implementar os testes usando Mocks -- após o front end
         - Implementar solução JWT usando KeyCloack -- Após o frontEnd

    - Solução FrontEnd
        - Implementar o Front End
 */


//
//
