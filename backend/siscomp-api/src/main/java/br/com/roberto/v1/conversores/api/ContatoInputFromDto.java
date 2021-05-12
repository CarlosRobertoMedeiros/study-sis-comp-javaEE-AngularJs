package br.com.roberto.v1.conversores.api;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.v1.model.input.ContatoInput;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class  ContatoInputFromDto {

    public static ContatoInput toDto(ContatoDto contatoDto){
        ContatoInput contatoModel = new ContatoInput();

        try {
            BeanUtils.copyProperties(contatoModel,contatoDto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return contatoModel;
    }

    public static List<ContatoInput> toCollectionDto(Iterable<? extends ContatoDto> contatosDto){

        List<ContatoInput> contatosInput = new ArrayList<>();
        contatosDto.forEach( contato ->{
            ContatoInput contatoInput = new ContatoInput();
            try {
                BeanUtils.copyProperties(contatoInput,contato);
                contatosInput.add(contatoInput);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return contatosInput;

    }

}