package br.com.cadastroPet.CadastroPet.Repository;

import br.com.cadastroPet.CadastroPet.Model.Animal;
import br.com.cadastroPet.CadastroPet.Model.TIPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByType(TIPO tipo);
    List<Animal> findByBreedEqualsIgnoreCase(String breed);
    List<Animal> findByFirstNameContainingIgnoreCase(String nome);


}
