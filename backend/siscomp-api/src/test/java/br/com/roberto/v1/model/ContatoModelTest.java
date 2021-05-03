package br.com.roberto.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatoModelTest {

    private Long idContato;
    private String cpf;
    private String nome;
    private String telefone;

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoModelTest that = (ContatoModelTest) o;
        return idContato.equals(that.idContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContato);
    }
}
