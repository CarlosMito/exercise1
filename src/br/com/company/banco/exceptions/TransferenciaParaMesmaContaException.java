package br.com.company.banco.exceptions;

public class TransferenciaParaMesmaContaException extends RuntimeException {
    public TransferenciaParaMesmaContaException() {
        super("Uma conta não pode transferir dinheiro para si própria");
    }
}
