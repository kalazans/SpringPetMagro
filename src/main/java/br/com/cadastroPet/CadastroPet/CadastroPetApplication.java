package br.com.cadastroPet.CadastroPet;

import br.com.cadastroPet.CadastroPet.DTOS.CadastroDTO;
import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPetApplication.class, args);
	}

}
