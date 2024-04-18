package br.com.virtualbooks.tabernabooks.livro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final EntityManager manager;
    LivroController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest){
        Livro livro = novoLivroRequest.mapToModel(manager);

        manager.persist(livro);
        return livro.toString();
    }

    @GetMapping
    public String listarLivros() {
        Query query = manager.createQuery("select l FROM Livro l");
        List<Livro> resultList = query.getResultList();

        return resultList.toString();
    }
}
