package br.com.cadastroPet.CadastroPet.DTOS;

import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;

public record AdressDTO(String cidade, String rua, String numero) {
    public AdressDTO{
        ValidadorInfo.validarNotNullorBlank(cidade);
        ValidadorInfo.validarNotNullorBlank(rua);
        ValidadorInfo.validarNotNullorBlank(numero);



    }
}
