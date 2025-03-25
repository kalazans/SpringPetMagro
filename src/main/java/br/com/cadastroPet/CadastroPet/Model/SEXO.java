package br.com.cadastroPet.CadastroPet.Model;

public enum SEXO {
    MACHO("MACHO"),
    FEMEA("FEMEA");

    private String sexo;
     SEXO (String sexo){
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
