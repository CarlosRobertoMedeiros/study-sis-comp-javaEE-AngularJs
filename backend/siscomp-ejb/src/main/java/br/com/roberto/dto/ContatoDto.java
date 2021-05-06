package br.com.roberto.dto;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDto {

    @EqualsAndHashCode.Include
    private Long idContato;
    private String cpf;
    private String nome;
    private String telefone;

}
