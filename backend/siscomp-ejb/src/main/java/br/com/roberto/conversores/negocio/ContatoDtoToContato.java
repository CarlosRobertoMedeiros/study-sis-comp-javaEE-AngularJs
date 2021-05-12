package br.com.roberto.conversores.negocio;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//TODO: Mudar o nome da Classe e tratar os catchs passando um erro padrão
public abstract class ContatoDtoToContato {

    public static ContatoDto toDtoObject(Contato contato){
        ContatoDto contatoDto = new ContatoDto();

        try {
            BeanUtils.copyProperties(contatoDto,contato);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return contatoDto;
    }

    public static List<ContatoDto> toCollectionDtoObject(Iterable<? extends Contato> contatosInput){

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
