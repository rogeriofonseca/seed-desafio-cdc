package br.com.virtualbooks.tabernabooks.cadastrolivro;

import br.com.virtualbooks.tabernabooks.novoautor.Autor;
import br.com.virtualbooks.tabernabooks.cadastrocategoria.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumoLivro;
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Positive
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;

    @FutureOrPresent
    private LocalDate dataPublicacao;

    @NotNull
    @OneToOne
    @PrimaryKeyJoinColumn
    private Categoria categoria;

    @NotNull
    @OneToOne
    @PrimaryKeyJoinColumn
    private Autor autor;

    public Livro(String titulo, String resumoLivro, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria idCategoria, Autor idAutor) {
        this.titulo = titulo;
        this.resumoLivro = resumoLivro;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = idCategoria;
        this.autor = idAutor;
    }
}
