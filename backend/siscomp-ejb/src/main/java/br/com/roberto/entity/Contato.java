package br.com.roberto.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_CONTATOS", schema = "SISCOMP")
public class Contato implements Serializable {

    public Contato(String nome,String telefone,Calendar dataUltimaAtualizacao, Operadora operadora){
        this.nome = nome;
        this.telefone = telefone;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.operadora = operadora;
    }

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_CONTATOS")
    @SequenceGenerator(name = "GEN_CONTATOS", sequenceName = "SEQ_CONTATO", schema = "SISCOMP", allocationSize = 1)
    @Column(name = "NU_CONTATO")
    private Long idContato;

    @Column(name = "NO_NOME_CONTATO", length = 100, nullable = false)
    private String nome;

    @Column(name = "NM_TELEFONE_CONTATO", length = 16, nullable = false)
    private String telefone;

    @Column(name = "DT_ULTIMA_ATUALIZACAO_CONTATO", length = 100, nullable = false)
    private Calendar dataUltimaAtualizacao = GregorianCalendar.getInstance();

    @OneToOne()
    @JoinColumn(name = "CO_OPERADORA", referencedColumnName = "CO_OPERADORA")
    private Operadora operadora;
}
