package br.com.cadastroPet.CadastroPet.Model;

public enum TIPO {
    GATO("GATO"),
    CACHORRO("CACHORRO"),
    PASSARO("PASSARO");

    private String tipoAnimal;

     TIPO(String tipo){
         this.tipoAnimal = tipo;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
}
