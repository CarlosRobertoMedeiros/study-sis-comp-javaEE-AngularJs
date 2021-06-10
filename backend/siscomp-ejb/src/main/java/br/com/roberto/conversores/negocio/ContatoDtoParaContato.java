package br.com.roberto.conversores.negocio;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.helper.DataHelper;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ContatoDtoParaContato {

    public static Contato toDto(ContatoDto contatoDto){
//        ModelMapper modelMapper = new ModelMapper();
        Contato contato = new Contato();
        contato.setNome(contatoDto.getNome());
        contato.setTelefone(contatoDto.getTelefone());
        contato.setDataNascimento(DataHelper.stringToDate(contatoDto.getDataNascimento()));
        contato.setOperadora(contatoDto.getOperadora());
        //Contato contato = modelMapper.map(contatoDto, Contato.class );
        return contato;
    }

    public static List<Contato> toCollectionDto(Iterable<? extends ContatoDto> contatosDto){

        List<Contato> contatos = new ArrayList<>();
        contatosDto.forEach( contato ->{
            ModelMapper modelMapper = new ModelMapper();
            Contato contatoInterno = modelMapper.map(contato, Contato.class);
            contatos.add(contatoInterno);
        });
        return contatos;
    }
}
