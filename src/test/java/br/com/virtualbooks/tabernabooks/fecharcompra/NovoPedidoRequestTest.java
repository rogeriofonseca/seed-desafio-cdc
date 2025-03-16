package br.com.virtualbooks.tabernabooks.fecharcompra;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NovoPedidoRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Test valid ItensCompraRequest")
    public void testValidItensCompraRequest() {
        NovoPedidoRequest request = new NovoPedidoRequest();
        request.setTotal(BigDecimal.valueOf(100));
        NovoItemPedido novoItemPedido = new NovoItemPedido();
        novoItemPedido.setIdLivro(1L);
        novoItemPedido.setQuantidade(2);
        request.setItens(List.of(novoItemPedido));

        Set<ConstraintViolation<NovoPedidoRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Test invalid ItensCompraRequest")
    public void testInvalidItensCompraRequest() {
        NovoPedidoRequest request = new NovoPedidoRequest();
        request.setTotal(BigDecimal.valueOf(-100)); // Invalid total
        NovoItemPedido novoItemPedido = new NovoItemPedido();
        novoItemPedido.setQuantidade(-2); // Invalid quantidade
        request.setItens(List.of());

        Set<ConstraintViolation<NovoPedidoRequest>> violations = validator.validate(request);
        assertEquals(2, violations.size());
    }
}