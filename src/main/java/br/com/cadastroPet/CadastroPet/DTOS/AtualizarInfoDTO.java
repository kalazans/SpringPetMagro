package br.com.cadastroPet.CadastroPet.DTOS;

import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;

public record AtualizarInfoDTO(String age, String weight) {
    public AtualizarInfoDTO{
        ValidadorInfo.validarNotNullorBlank(age);
        ValidadorInfo.validarNotNullorBlank(weight);
    }
}
