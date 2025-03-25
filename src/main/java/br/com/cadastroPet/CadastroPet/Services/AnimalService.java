package br.com.cadastroPet.CadastroPet.Services;

import br.com.cadastroPet.CadastroPet.Model.Animal;
import br.com.cadastroPet.CadastroPet.Model.TIPO;
import br.com.cadastroPet.CadastroPet.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public void salvar(Animal animal){
        animalRepository.save(animal);
    }

    public List<Animal> listaDB(){
        return  animalRepository.findAll();
    }

    public List<Animal> listaPorTipo(TIPO tipo){
         return animalRepository.findByType(tipo);
    }

    public List<Animal> listaPorRaça(String raça){
        return animalRepository.findByBreedEqualsIgnoreCase(raça);
    }


    public List<Animal> listaPorNome(String nome) {
        return animalRepository.findByFirstNameContainingIgnoreCase(nome);
    }

    public Animal acharPorId(Long id){
        return animalRepository.getReferenceById(id);
    }

    public void deletar(Long id){
        animalRepository.deleteById(id);

    }

}
