package br.com.roberto.v1.conversores.api;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.v1.model.input.ContatoInput;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class ContatoInputToDto {

    public static ContatoDto toDtoObject(ContatoInput contatoInput){
        ContatoDto contatoDto = new ContatoDto();

        try {
            BeanUtils.copyProperties(contatoDto,contatoInput);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return contatoDto;
    }

    public static List<ContatoDto> toCollectionDtoObject(Iterable<? extends ContatoInput> contatosInput){

        List<ContatoDto> contatos = new ArrayList<>();
        contatosInput.forEach( contatoInput ->{
            ContatoDto contatoInternoDto = new ContatoDto();
            try {
                BeanUtils.copyProperties(contatoInternoDto,contatoInput);
                contatos.add(contatoInternoDto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return contatos;
    }




}
