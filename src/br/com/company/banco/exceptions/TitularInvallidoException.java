package br.com.company.banco.exceptions;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.contas.Conta;

public class TitularInvallidoException extends RuntimeException {
    public TitularInvallidoException(Cliente titular, Conta conta) {
        super("O cliente do tipo " + titular.getClass().getSimpleName() + " não pode abrir uma conta do tipo " + conta.getClass().getSimpleName());
    }
}