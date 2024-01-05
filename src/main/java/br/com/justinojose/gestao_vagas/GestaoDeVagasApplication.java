package br.com.justinojose.gestao_vagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(
//				title = "Gestão de Vagas",
//				description = "API responsável pela gestão de vagas",
//				version = "1"
//		)
//)
//@SecurityScheme(name = "jwt_auth", scheme = "bearer", bearerFormat = "JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class GestaoDeVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeVagasApplication.class, args);
	}

}
