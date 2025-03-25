package br.com.cadastroPet.CadastroPet.Infra.Exceptions;

public class PesoInvalidoException extends  RuntimeException{
    public PesoInvalidoException(String message){
        super(message);
    }
}
