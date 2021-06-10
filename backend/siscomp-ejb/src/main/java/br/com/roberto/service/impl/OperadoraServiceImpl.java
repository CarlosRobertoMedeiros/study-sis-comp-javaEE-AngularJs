package br.com.roberto.service.impl;

import br.com.roberto.conversores.negocio.ContatoParaContatoDto;
import br.com.roberto.conversores.negocio.OperadoraParaOperadoraDto;
import br.com.roberto.dto.ContatoDto;
import br.com.roberto.dto.ContatosDto;
import br.com.roberto.dto.OperadoraDto;
import br.com.roberto.dto.OperadorasDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.entity.Operadora;
import br.com.roberto.exceptions.NegocioException;
import br.com.roberto.repository.OperadoraRepository;
import br.com.roberto.service.OperadoraService;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OperadoraServiceImpl implements OperadoraService, Serializable {

    private static ResourceBundle rb = ResourceBundle.getBundle("messages-negocio_PT-BR");

    @Inject
    private OperadoraRepository operadoraRepository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public OperadorasDto getOperadoras() {
        List<Operadora> operadoras = null;
        List<OperadoraDto> operadorasResponse = null;
        try{
            operadoras = operadoraRepository.findAll();
            //TODO: Implementar o OperadoraParaOperadoraDTO.toCollectionDtoObject
            operadorasResponse = OperadoraParaOperadoraDto.toCollectionDtoObject(operadoras);
            OperadorasDto operadorasDto = new OperadorasDto();
            operadorasDto.setOperadoras(operadorasResponse);
            return operadorasDto;
        }catch (Exception e){
            throw new NegocioException(rb.getString("OPERADORAS_NAO_ENCONTRADAS"));
        }
    }
}
