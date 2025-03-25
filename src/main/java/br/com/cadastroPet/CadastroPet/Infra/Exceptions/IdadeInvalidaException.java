package br.com.cadastroPet.CadastroPet.Infra.Exceptions;

public class IdadeInvalidaException extends RuntimeException{
    public IdadeInvalidaException(String message){
        super(message);
    }
}
