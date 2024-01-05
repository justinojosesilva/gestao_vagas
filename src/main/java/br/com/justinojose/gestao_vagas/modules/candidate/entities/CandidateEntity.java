package br.com.justinojose.gestao_vagas.modules.candidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "José da Silva", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do Candidato")
    private String name;

    @NotBlank()
    @Schema(example = "josesilva", requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do Candidato")
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Schema(example = "josesilva@teste.com.br",requiredMode = Schema.RequiredMode.REQUIRED, description = "Email do Candidato")
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Schema(example = "joses@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do Candidato")
    @Length(min = 10, max = 100, message = "O campo [password] deve conter entre (10) e (100) caracteres")
    private String password;

    @Schema(example = "Desenvolvedor Java", requiredMode = Schema.RequiredMode.REQUIRED, description = "Breve descrição do Candidato")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
