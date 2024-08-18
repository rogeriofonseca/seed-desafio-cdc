package br.com.virtualbooks.tabernabooks.paisestado;

import br.com.virtualbooks.tabernabooks.shared.ExistsId;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NovoEstadoRequest {
    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public Estado toMap(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }
}
