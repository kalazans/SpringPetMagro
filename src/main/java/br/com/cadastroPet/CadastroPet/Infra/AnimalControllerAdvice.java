package br.com.cadastroPet.CadastroPet.Infra;

import br.com.cadastroPet.CadastroPet.Infra.Exceptions.IdadeInvalidaException;
import br.com.cadastroPet.CadastroPet.Infra.Exceptions.PesoInvalidoException;
import br.com.cadastroPet.CadastroPet.Infra.Exceptions.ValidarException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AnimalControllerAdvice {
    @ExceptionHandler(ValidarException.class)
    public ResponseEntity erroValidar(ValidarException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity buscaNaoValida(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());

    }
    @ExceptionHandler(PesoInvalidoException.class)
    public ResponseEntity pesoInvalido(PesoInvalidoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(IdadeInvalidaException.class)
    public ResponseEntity idadeInvalida(IdadeInvalidaException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratar404() {
        return ResponseEntity.notFound().build();
    }
}
