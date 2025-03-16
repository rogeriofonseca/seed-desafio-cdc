package br.com.virtualbooks.tabernabooks.fecharcompra;

import br.com.virtualbooks.tabernabooks.cadastrolivro.Livro;
import br.com.virtualbooks.tabernabooks.shared.ExistsId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public class NovoPedidoRequest {
    @Positive
    BigDecimal total;

    @Valid
    @NotEmpty
    List<NovoItemPedido> itens;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NovoItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<NovoItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "ItensCompraRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }
}

class NovoItemPedido {
    @ExistsId(domainClass = Livro.class, fieldName = "id")
    @NotNull
    Long idLivro;
    @Positive
    Integer quantidade;

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }
}
