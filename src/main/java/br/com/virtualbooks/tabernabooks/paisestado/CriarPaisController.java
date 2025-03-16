package br.com.virtualbooks.tabernabooks.paisestado;

import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
public class CriarPaisController {
    private final EntityManager manager;

    public CriarPaisController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrosPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
        Pais pais = new Pais(novoPaisRequest.getNome());

        manager.persist(pais);
        return ResponseEntity.ok().body(pais);
    }

    @GetMapping
    public ResponseEntity<?> listarPaises() {
        return ResponseEntity.ok().body(manager.createQuery("SELECT p FROM Pais p").getResultList());
    }
}
