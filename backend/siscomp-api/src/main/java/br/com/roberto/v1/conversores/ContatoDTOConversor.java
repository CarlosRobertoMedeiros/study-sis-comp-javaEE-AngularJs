package br.com.roberto.v1.conversores;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.v1.model.ContatoModel;

public abstract class ContatoDTOConversor {

    public static ContatoDto converterContatoDto(ContatoModel contato){
        return new ContatoDto(
                                contato.getId(),
                                contato.getCpf(),
                                contato.getNome(),
                                contato.getTelefone()
                             );
    }

}
