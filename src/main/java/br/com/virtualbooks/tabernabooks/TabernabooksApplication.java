package br.com.virtualbooks.tabernabooks;

import br.com.virtualbooks.tabernabooks.novoautor.AutorRepository;
import br.com.virtualbooks.tabernabooks.novoautor.AutorRequest;
import br.com.virtualbooks.tabernabooks.cadastrocategoria.CategoriaRepository;
import br.com.virtualbooks.tabernabooks.cadastrocategoria.CategoriaRequest;
import br.com.virtualbooks.tabernabooks.paisestado.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TabernabooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabernabooksApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		AutorRequest rogerio = new AutorRequest("Rogério Fonseca", "rogerio@gmail.com", "Author Tech tech");
		AutorRequest alice = new AutorRequest("Melissa", "melissa@gmail.com", "Fiction");

		CategoriaRequest categoria1 = new CategoriaRequest("Fiction");
		return args -> {
			autorRepository.save(rogerio.mapToModel());
			autorRepository.save(alice.mapToModel());

			categoriaRepository.save(categoria1.mapToModel());
		};
	}

}
