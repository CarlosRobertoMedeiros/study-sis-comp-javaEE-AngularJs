package br.com.roberto.v1.conversores.api;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.v1.model.input.ContatoInput;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class ContatoDtoParaContatoInput {

    public static ContatoInput toDto(ContatoDto contatoDto){
        ModelMapper modelMapper = new ModelMapper();
        ContatoInput contatoModel = modelMapper.map(contatoDto, ContatoInput.class);
        return contatoModel;
    }

    public static List<ContatoInput> toCollectionDto(Iterable<? extends ContatoDto> contatosDto){

        List<ContatoInput> contatosInput = new ArrayList<>();
        contatosDto.forEach( contato ->{
            ModelMapper modelMapper = new ModelMapper();
            ContatoInput contatoModel = modelMapper.map(contato, ContatoInput.class);
            contatosInput.add(contatoModel);
        });
        return contatosInput;
    }
}