package br.com.roberto.conversores.negocio;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//TODO: Mudar o nome da Classe e tratar os catchs passando um erro padrão
public abstract class ContatoDtoFromContato {

    public static Contato toDto(ContatoDto contatoDto){
        Contato contato = new Contato();

        try {
            BeanUtils.copyProperties(contato,contatoDto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return contato;
    }

    public static List<Contato> toCollectionDto(Iterable<? extends ContatoDto> contatosDto){

        List<Contato> contatosInput = new ArrayList<>();
        contatosDto.forEach( contato ->{
            Contato contatoInput = new Contato();
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
