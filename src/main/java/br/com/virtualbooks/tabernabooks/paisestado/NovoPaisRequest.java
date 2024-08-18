package br.com.virtualbooks.tabernabooks.paisestado;

import br.com.virtualbooks.tabernabooks.shared.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovoPaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

//    @NotNull
//    private Long estadoId;

}
