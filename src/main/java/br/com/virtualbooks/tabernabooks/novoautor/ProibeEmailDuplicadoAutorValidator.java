package br.com.virtualbooks.tabernabooks.novoautor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
    private final AutorRepository autorRepository;

    public ProibeEmailDuplicadoAutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequest request = (AutorRequest) target;
        Optional<Autor> autorCadastrado = autorRepository.findByEmail(request.getEmail());
        if(autorCadastrado.isPresent()){
            String emailCadastrado = autorCadastrado.get().getEmail();
            errors.reject("email", null, String.format("Email já cadastrado: %s", emailCadastrado));
        }

    }
}
