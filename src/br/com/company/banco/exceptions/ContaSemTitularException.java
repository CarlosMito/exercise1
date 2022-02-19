package br.com.company.banco.exceptions;

public class ContaSemTitularException extends RuntimeException {
    public ContaSemTitularException() {
        super("Uma conta não pode ficar sem um titular!");
    }
}
