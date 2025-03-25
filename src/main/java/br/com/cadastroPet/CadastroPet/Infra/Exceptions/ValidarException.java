package br.com.cadastroPet.CadastroPet.Infra.Exceptions;

public class ValidarException extends RuntimeException{
    public ValidarException(String message){
        super(message);
    }
}
