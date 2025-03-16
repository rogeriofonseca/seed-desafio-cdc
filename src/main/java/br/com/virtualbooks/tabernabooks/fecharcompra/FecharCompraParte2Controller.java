package br.com.virtualbooks.tabernabooks.fecharcompra;

import jakarta.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FecharCompraParte2Controller {

    @InitBinder
    public void init(WebDataBinder binder) {
    }
    @PostMapping(value = "/compraParte2")
    public String fecharCompraParte1Controller(@Valid @RequestBody NovoPedidoRequest novoPedidoRequest) {
        novoPedidoRequest.toString();
        System.out.println(novoPedidoRequest.toString());
        return novoPedidoRequest.toString();
    }
}
