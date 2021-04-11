package br.com.roberto.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_Contatos", schema = "SISCOMP")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_CONTATOS")
    @SequenceGenerator(name = "GEN_CONTATOS", sequenceName = "SEQ_CONTATOS", schema = "SISCOMP", allocationSize = 1)
    @Column(name = "NU_SQNCL_ATENDIMENTO")
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();



}
