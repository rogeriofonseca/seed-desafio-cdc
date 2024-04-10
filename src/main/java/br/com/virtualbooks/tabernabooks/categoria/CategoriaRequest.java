package br.com.virtualbooks.tabernabooks.categoria;

import br.com.virtualbooks.tabernabooks.shared.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria mapToModel() {
        return new Categoria(
                this.getNome()
        );
    }
}
