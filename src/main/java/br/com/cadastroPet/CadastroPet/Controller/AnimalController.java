package br.com.cadastroPet.CadastroPet.Controller;

import br.com.cadastroPet.CadastroPet.DTOS.AnimalDTO;
import br.com.cadastroPet.CadastroPet.DTOS.AtualizarInfoDTO;
import br.com.cadastroPet.CadastroPet.DTOS.CadastroDTO;
import br.com.cadastroPet.CadastroPet.Model.Animal;
import br.com.cadastroPet.CadastroPet.Model.TIPO;
import br.com.cadastroPet.CadastroPet.Services.AnimalService;
import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;
    @PostMapping("/animal")
    @Transactional
    public ResponseEntity salver(@RequestBody CadastroDTO dto, UriComponentsBuilder uri){
        Animal animal = new Animal(dto);
        animalService.salvar(animal);
        var link =  uri.path("/animal/{id}").buildAndExpand(animal).toUri();
        return ResponseEntity.created(link).body(new AnimalDTO(animal));

    }
    @GetMapping("/animal/lista")
    public ResponseEntity listaDB(){
        return ResponseEntity.ok(animalService.listaDB().stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList()));
    }
    @GetMapping("/animal/busca")
    public ResponseEntity listaPorTipo(@RequestParam Optional<String> tipo,
                                        @RequestParam Optional<String> raça,
                                        @RequestParam Optional<String> nome
                                        ){
       if(tipo.isPresent() && ValidadorInfo.validarTypeParameter(tipo.get())){
           return ResponseEntity.ok(animalService.listaPorTipo(TIPO.valueOf(tipo.get().toUpperCase())).stream().map(animal->new AnimalDTO(animal)).collect(Collectors.toList()));
       } else if(raça.isPresent() && ValidadorInfo.validarBreedParameter(raça.get())){
           return ResponseEntity.ok(animalService.listaPorRaça(raça.get()).stream().map(animal->new AnimalDTO(animal)).collect(Collectors.toList()));
       }else if(nome.isPresent() && ValidadorInfo.validarNomeParamter(nome.get())){
           return ResponseEntity.ok(animalService.listaPorNome(nome.get()).stream().map(animal->new AnimalDTO(animal)).collect(Collectors.toList()));
       }else{
           return ResponseEntity.badRequest().body(new ArrayList<AnimalDTO>());
       }
    }

    @PutMapping("/animal/{id}")
    @Transactional
    public ResponseEntity atualizarInfo(@PathVariable Long id, @RequestBody AtualizarInfoDTO atualizarInfoDTO){
        Animal animal =  animalService.acharPorId(id);
        animal.atualizar(atualizarInfoDTO);
        return ResponseEntity.ok(new AnimalDTO((animal)));
    }
    @DeleteMapping("/animal/{id}")
    @Transactional
    public ResponseEntity deletarPorId(@PathVariable Long id){
        animalService.deletar(id);
        return ResponseEntity.ok().body("apagado");

    }
    @GetMapping("/animal/{id}")
    public ResponseEntity animalPorId(@PathVariable Long id){
        return ResponseEntity.ok(new AnimalDTO(animalService.acharPorId(id)));
    }




}
