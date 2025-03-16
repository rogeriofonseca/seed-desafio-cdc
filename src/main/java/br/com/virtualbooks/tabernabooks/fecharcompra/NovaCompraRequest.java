package br.com.virtualbooks.tabernabooks.fecharcompra;

import br.com.virtualbooks.tabernabooks.paisestado.Estado;
import br.com.virtualbooks.tabernabooks.paisestado.Pais;
import br.com.virtualbooks.tabernabooks.shared.ExistsId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class NovaCompraRequest {

    private String pais;
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPF
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    @NotNull
    private Long paisId;
    @NotNull
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long estadoId;
    @NotBlank
    private String telefone;
    private String cep;

    @Override
    public String toString() {
        return "NovaCompraRequest{" +
                "pais='" + pais + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", paisId=" + paisId +
                ", estadoId=" + estadoId +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                '}';
    }

    @Valid
    @NotNull
    private NovoPedidoRequest pedido;

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public void setPedido(NovoPedidoRequest pedido) {
        this.pedido = pedido;
    }

    /**
     * Constrói uma nova NovaCompraRequest.
     *
     * @param pais       o país da compra
     * @param email      o email do comprador
     * @param nome       o nome do comprador
     * @param sobrenome  o sobrenome do comprador
     * @param documento  o documento (CPF) do comprador
     * @param endereco   o endereço do comprador
     * @param complemento o complemento do endereço
     * @param cidade     a cidade do comprador
     * @param paisId     o ID do país
     * @param estadoId   o ID do estado
     * @param telefone   o número de telefone do comprador
     * @param cep        o código postal
     * @param pedido     os detalhes do pedido
     */
    public NovaCompraRequest(String pais, String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                             String cidade, Long paisId, Long estadoId, String telefone, String cep, @Valid @NotNull NovoPedidoRequest pedido) {
        this.pais = pais;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
        
    }
}
