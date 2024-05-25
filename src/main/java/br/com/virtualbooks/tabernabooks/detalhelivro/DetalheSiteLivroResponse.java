package br.com.virtualbooks.tabernabooks.detalhelivro;

import br.com.virtualbooks.tabernabooks.cadastrolivro.Livro;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DetalheSiteLivroResponse {

    private DetalheSiteAutorResponse autor;
    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;

    public DetalheSiteLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DetalheSiteAutorResponse(livro.getAutor());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumoLivro();
        sumario = livro.getSumario();
    }
}
