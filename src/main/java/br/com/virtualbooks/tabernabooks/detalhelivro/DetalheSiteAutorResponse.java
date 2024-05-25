package br.com.virtualbooks.tabernabooks.detalhelivro;

import br.com.virtualbooks.tabernabooks.novoautor.Autor;
import lombok.Getter;

@Getter
public class DetalheSiteAutorResponse {

    private String nome;
    private String descricao;

    public DetalheSiteAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}
