package br.com.virtualbooks.tabernabooks.autor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Entity(name = "Autor")
@Table(name = "autores")
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor(force = true)
public class Autor {

    LocalDateTime instanteDeCriacao = LocalDateTime.now();

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo 'nome' é obrigatório")
    private final String nome;

    @NotBlank(message = "O campo 'email' é obrigatório")
    @Email(message = "O campo 'email' deve ser um endereço de e-mail válido")
    private final String email;

    @NotBlank(message = "O campo 'descrição' é obrigatório")
    @Size(max = 400, message = "O campo 'descrição' não pode ter mais de 400 caracteres")
    private final String descricao;


    public Autor(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
