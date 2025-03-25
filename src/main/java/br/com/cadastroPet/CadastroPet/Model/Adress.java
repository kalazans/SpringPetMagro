package br.com.cadastroPet.CadastroPet.Model;

import br.com.cadastroPet.CadastroPet.DTOS.AdressDTO;
import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {
    private String cidade;
    private String rua;
    private String numero;

    public Adress(){}
    public Adress(AdressDTO adressDTO){
        this.cidade= ValidadorInfo.validarCidade(adressDTO.cidade());
        this.rua = ValidadorInfo.validarRua(adressDTO.rua());
        this.numero = ValidadorInfo.validarNumero(adressDTO.numero());
    }


    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }
}
