package br.com.justinojose.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    private UUID id;

    @Schema(example = "Maria")
    private String name;

    @Schema(example = "Desenvolvedora Java")
    private String description;

    @Schema(example = "maria")
    private String username;

    @Schema(example = "maria@teste.com")
    private String email;
}
