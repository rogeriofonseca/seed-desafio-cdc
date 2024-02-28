package br.com.virtualbooks.tabernabooks.autor;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    AutorRepository autorRepository;

    @PostMapping
    public String cadastrar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.mapToModel();
        autorRepository.save(autor);
        return autor.toString();
    }


    @GetMapping
    public List<Autor> autores() {
        return autorRepository.findAll();
    }
}
