package br.com.roberto.v1.conversores;

import br.com.roberto.entity.Contato;
import br.com.roberto.v1.model.ContatoModel;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@AllArgsConstructor
public abstract class ContatoModelConversor {

    /*
    public static ContatoDto converterContatoDto(ContatoModel contato){
        return new ContatoDto(
                                contato.getId(),
                                contato.getCpf(),
                                contato.getNome(),
                                contato.getTelefone()
                             );
    }

     */

    public ContatoModel toModel(Contato contato){
        ContatoModel contatoModel = new ContatoModel();

        try {
            BeanUtils.copyProperties(contatoModel,contato);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return contatoModel;
    }

    //TODO:Continuar Implementando esse parse depois implementar o parse inverso
    public List<ContatoModel> toCollectionModel(Iterable<? extends Contato> entities){
        ContatoModel contatoModel = new ContatoModel();

        try {
            BeanUtils.copyProperties(contatoModel,contato);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }




}
