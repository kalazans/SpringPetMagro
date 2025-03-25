package br.com.cadastroPet.CadastroPet.DTOS;

import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;

public record CadastroDTO(String name,
                          String lastName,
                          String sexo,
                          AdressDTO adress,
                          String age,
                          String weight,
                          String breed,
                          String type)
{
    public CadastroDTO{
        ValidadorInfo.validarNotNullorBlank(name);
        ValidadorInfo.validarNotNullorBlank(lastName);
        ValidadorInfo.validarNotNullorBlank(sexo);
        ValidadorInfo.validarNotNullorBlank(age);
        ValidadorInfo.validarNotNullorBlank(weight);
        ValidadorInfo.validarNotNullorBlank(breed);
        ValidadorInfo.validarNotNullorBlank(type);

    }




}
