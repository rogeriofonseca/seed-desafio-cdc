package br.com.virtualbooks.tabernabooks.categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Table(name = "categorias")
@NoArgsConstructor(force = true)
public class Categoria {
    public Categoria(String nome){
        this.setNome(nome);
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo 'nome' é obrigatório")
    private String nome;
}
