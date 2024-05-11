package br.com.virtualbooks.tabernabooks.livro;

import br.com.virtualbooks.tabernabooks.autor.Autor;
import br.com.virtualbooks.tabernabooks.autor.AutorRepository;
import br.com.virtualbooks.tabernabooks.categoria.Categoria;
import br.com.virtualbooks.tabernabooks.categoria.CategoriaRepository;
import br.com.virtualbooks.tabernabooks.shared.ExistsId;
import br.com.virtualbooks.tabernabooks.shared.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Service
public class NovoLivroRequest {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public NovoLivroRequest(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @UniqueValue(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumoLivro;
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public Livro mapToModel(EntityManager manager){
        Categoria categoria = manager.getReference(Categoria.class, idCategoria);
        Autor autor = manager.getReference(Autor.class, idAutor);

        return new Livro(
                this.getTitulo(),
                this.getResumoLivro(),
                this.getSumario(),
                this.getPreco(),
                this.getNumeroPaginas(),
                this.getIsbn(),
                this.getDataPublicacao(),
                categoria,
                autor
        );
    }

}
