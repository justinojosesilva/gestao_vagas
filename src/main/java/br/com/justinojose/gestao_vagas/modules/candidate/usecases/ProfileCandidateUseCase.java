package br.com.justinojose.gestao_vagas.modules.candidate.usecases;

import br.com.justinojose.gestao_vagas.exceptions.UserNotFoundException;
import br.com.justinojose.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.justinojose.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });
        return ProfileCandidateResponseDTO.builder()
                .id(candidate.getId())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .username(candidate.getUsername())
                .description(candidate.getDescription())
                .build();
    }
}
