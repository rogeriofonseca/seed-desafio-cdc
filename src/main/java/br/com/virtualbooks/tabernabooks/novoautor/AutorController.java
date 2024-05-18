package br.com.virtualbooks.tabernabooks.novoautor;

import jakarta.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    AutorController(ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator, AutorRepository autorRepository) {
        this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator;
        this.autorRepository = autorRepository;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    private final ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

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
