package br.com.roberto.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ContatoDto {

    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    public ContatoDto() {}

    public ContatoDto(Long id, String cpf, String nome, String telefone, LocalDateTime dataUltimaAtualizacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
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

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoDto that = (ContatoDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
