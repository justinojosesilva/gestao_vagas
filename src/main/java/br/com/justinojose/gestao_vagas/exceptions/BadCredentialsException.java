package br.com.justinojose.gestao_vagas.exceptions;

public class BadCredentialsException  extends RuntimeException {

    public BadCredentialsException() {
        super("Username/password incorrect!");
    }

}
