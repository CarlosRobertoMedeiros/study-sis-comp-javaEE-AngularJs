package br.com.roberto.conversores.negocio;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.helper.DataHelper;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class ContatoParaContatoDto {

    public static ContatoDto toDtoObject(Contato contato){
        //ModelMapper modelMapper = new ModelMapper();
        //ContatoDto contatoDto = modelMapper.map(contato, ContatoDto.class);
        //TODO: Corrigir a conversão do Objeto
        ContatoDto contatoDto = new ContatoDto();
        contatoDto.setNome(contato.getNome());
        contatoDto.setTelefone(contato.getTelefone());
        contatoDto.setDataNascimento(DataHelper.dateToString(contato.getDataNascimento()));
        contatoDto.setOperadora(contato.getOperadora());

        return contatoDto;
    }

    public static List<ContatoDto> toCollectionDtoObject(Iterable<? extends Contato> contatosInput){

        List<ContatoDto> contatosDto = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        contatosInput.forEach( contatoInput ->{
            ContatoDto contatoInterno = modelMapper.map(contatoInput, ContatoDto.class);
            contatosDto.add(contatoInterno);
        });
        return contatosDto;
    }
}
