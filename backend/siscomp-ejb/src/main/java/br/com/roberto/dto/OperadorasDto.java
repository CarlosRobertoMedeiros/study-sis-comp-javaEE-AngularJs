package br.com.roberto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OperadorasDto {

    @JsonProperty("operadoras")
    private List<OperadoraDto> operadoras;

    @JsonIgnore
    public List<OperadoraDto> getOperadoras() {
        return operadoras;
    }

    @JsonIgnore
    public void setOperadoras(List<OperadoraDto> operadoras) {
        this.operadoras = operadoras;
    }
}
