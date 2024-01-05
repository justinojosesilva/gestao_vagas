package br.com.justinojose.gestao_vagas.modules.candidate.controllers;

import br.com.justinojose.gestao_vagas.modules.candidate.dto.AuthCadidateRequestDTO;
import br.com.justinojose.gestao_vagas.modules.candidate.usecases.AuthCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;
    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthCadidateRequestDTO authCadidateRequestDTO) {
        try {
            var token = this.authCandidateUseCase.execute(authCadidateRequestDTO);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
