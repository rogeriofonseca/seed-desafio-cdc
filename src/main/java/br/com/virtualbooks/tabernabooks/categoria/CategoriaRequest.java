package br.com.virtualbooks.tabernabooks.categoria;

import lombok.Data;

@Data
public class CategoriaRequest {
    private String nome;

    public Categoria mapToModel() {
        return new Categoria(
                this.getNome()
        );
    }
}
