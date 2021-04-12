package br.com.roberto.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CONTATOS", schema = "SISCOMP")
public class Contato implements Serializable {

    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    public Contato(){}

    public Contato(Long id, String cpf, String nome, String telefone, LocalDateTime dataUltimaAtualizacao) {
        super();
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_CONTATOS")
    @SequenceGenerator(name = "GEN_CONTATOS", sequenceName = "SEQ_CONTATO", schema = "SISCOMP", allocationSize = 1)
    @Column(name = "NU_CONTATO")
    public Long getId() {
        return id;
    }
    @Column(name = "CO_CPF_CONTATO", length = 11, nullable = false)
    public String getCpf() {
        return cpf;
    }

    @Column(name = "NO_NOME_CONTATO", length = 100, nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(name = "CO_TELEFONE_CONTATO", length = 100, nullable = false)
    public String getTelefone() {
        return telefone;
    }

    @Column(name = "DT_ULTIMA_ATUALIZACAO_CONTATO", length = 100, nullable = false)
    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
