package br.com.virtualbooks.tabernabooks.livro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final EntityManager manager;
    LivroController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public String cadastrarLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest){
        Livro livro = novoLivroRequest.mapToModel();

        return livro.toString();
    }

    @GetMapping
    public String listarLivros() {
        Query query = manager.createQuery("select l FROM Livro l");
        return query.getResultList().toString();
    }
}