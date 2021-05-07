package br.com.roberto.dto;

import br.com.roberto.entity.Contato;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contatos"
})
public class ContatosDto {

    @JsonProperty("contatos")
    private List<ContatoDto> contatos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("contatos")
    public List<ContatoDto> getContatos() {
        return contatos;
    }

    @JsonProperty("contatos")
    public void setContatos(List<ContatoDto> contatos) {
        this.contatos = contatos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
