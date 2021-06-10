package br.com.roberto.conversores.negocio;

import br.com.roberto.dto.OperadoraDto;
import br.com.roberto.entity.Operadora;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class OperadoraParaOperadoraDto {

    public static OperadoraDto toDtoObject(Operadora operadora){
        ModelMapper modelMapper = new ModelMapper();
        OperadoraDto operadoraDto = modelMapper.map(operadora, OperadoraDto.class);
        return operadoraDto;
    }

    public static List<OperadoraDto> toCollectionDtoObject(Iterable<? extends Operadora> operadorasInput){

        List<OperadoraDto> operadorasDto = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        operadorasInput.forEach( operadoraInput ->{
            OperadoraDto operadoraInterna = modelMapper.map(operadoraInput, OperadoraDto.class);
            operadorasDto.add(operadoraInterna);
        });
        return operadorasDto;
    }
}
