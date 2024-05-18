package br.com.virtualbooks.tabernabooks.novoautor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo 'nome' é obrigatório")
    private final String nome;

    @NotBlank(message = "O campo 'email' é obrigatório")
    @Email(message = "O campo 'email' deve ser um endereço de e-mail válido")
    private final String email;

    @NotBlank(message = "O campo 'descrição' é obrigatório")
    @Size(max = 400, message = "O campo 'descrição' não pode ter mais de 400 caracteres")
    private final String descricao;

    public Autor mapToModel() {
        return new Autor(
                this.getNome(),
                this.getEmail(),
                this.getDescricao());
    }
}