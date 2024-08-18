package br.com.virtualbooks.tabernabooks.paisestado;

import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class CriarEstadoController {

    private final EntityManager manager;

    public CriarEstadoController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrosEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
        Estado estado = novoEstadoRequest.toMap(manager);

        manager.persist(estado);
        return ResponseEntity.ok().body(estado);
    }
}
