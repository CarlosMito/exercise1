package br.com.company.banco.exceptions;

public class OperacaoComValorNegativoException extends RuntimeException {
    public OperacaoComValorNegativoException() {
        super("Não é possível realizar uma operação com valores negativos!");
    }
}
