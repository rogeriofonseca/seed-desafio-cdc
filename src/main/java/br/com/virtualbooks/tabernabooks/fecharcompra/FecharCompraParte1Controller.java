package br.com.virtualbooks.tabernabooks.fecharcompra;

import jakarta.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FecharCompraParte1Controller {

    @InitBinder
    public void init(WebDataBinder binder) {
//        binder.addValidators(new ProibeEmailDuplicadoAutorValidator());
    }
    @PostMapping(value = "/compra")
    public String fecharCompraParte1Controller(@Valid @RequestBody NovaCompraRequest novaCompraRequest) {
        novaCompraRequest.toString();
        System.out.println(novaCompraRequest.toString());
        return novaCompraRequest.toString();
    }
}
