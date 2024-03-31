package br.com.virtualbooks.tabernabooks.categoria;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public String categoria(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.mapToModel();
        categoriaRepository.save(categoria);

        return categoria.toString();
    }

    @GetMapping
    public List<Categoria> categorias(){
        return categoriaRepository.findAll();
    }
}
