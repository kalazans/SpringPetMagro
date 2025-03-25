package br.com.cadastroPet.CadastroPet.DTOS;

import br.com.cadastroPet.CadastroPet.Model.Animal;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public record AnimalDTO(Long id,String name, String lastName, String type, String sexo, String age, Double weight, String breed,
                        String data) {
    public AnimalDTO(Animal animal){
        this(animal.getId(),animal.getFirstName(), animal.getLastName(),animal.getType().getTipoAnimal(),animal.getSex().getSexo(),
                animal.getAgeConfigurado(), animal.getWeight(), animal.getBreed(),
                animal.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }



}
