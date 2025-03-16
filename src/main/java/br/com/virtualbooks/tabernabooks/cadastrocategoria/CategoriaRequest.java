package br.com.virtualbooks.tabernabooks.cadastrocategoria;

import br.com.virtualbooks.tabernabooks.shared.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequest {
    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    public Categoria mapToModel() {
        return new Categoria(
                this.getNome()
        );
    }
}
