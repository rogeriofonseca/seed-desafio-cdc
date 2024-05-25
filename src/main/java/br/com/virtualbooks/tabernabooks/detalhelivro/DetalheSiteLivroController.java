package br.com.virtualbooks.tabernabooks.detalhelivro;

import br.com.virtualbooks.tabernabooks.cadastrolivro.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheSiteLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id){
        Livro livroBuscado = manager.find(Livro.class, id);

        // o find retorna null, entao tenho que verificar
        if(livroBuscado == null) {
            return ResponseEntity.notFound().build();
        }

        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheSiteLivroResponse);
    }
}
