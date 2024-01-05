package br.com.justinojose.gestao_vagas.modules.candidate.usecases;

import br.com.justinojose.gestao_vagas.exceptions.BadCredentialsException;
import br.com.justinojose.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.justinojose.gestao_vagas.modules.candidate.dto.AuthCadidateRequestDTO;
import br.com.justinojose.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCadidateRequestDTO authCadidateRequestDTO) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCadidateRequestDTO.username())
                .orElseThrow(() -> {
                    throw new BadCredentialsException();
                });

        var passwordMatches = this.passwordEncoder.matches(authCadidateRequestDTO.password(), candidate.getPassword());
        if(!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("ajConsultoriaVagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", Arrays.asList("CANDIDATE"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return AuthCandidateResponseDTO
                .builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

    }
}
