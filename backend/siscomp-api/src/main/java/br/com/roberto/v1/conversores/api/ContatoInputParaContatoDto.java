package br.com.roberto.v1.conversores.api;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.v1.model.input.ContatoInput;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class ContatoInputParaContatoDto {

    public static ContatoDto toDtoObject(ContatoInput contatoInput){
        ModelMapper modelMapper = new ModelMapper();
        ContatoDto contatoDto = modelMapper.map(contatoInput, ContatoDto.class);
        return contatoDto;
    }

    public static List<ContatoDto> toCollectionDtoObject(Iterable<? extends ContatoInput> contatosInput){

        List<ContatoDto> contatos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        contatosInput.forEach( contatoInput ->{
            ContatoDto contatoDto = modelMapper.map(contatoInput, ContatoDto.class);
            contatos.add(contatoDto);
        });

        return contatos;
    }

}