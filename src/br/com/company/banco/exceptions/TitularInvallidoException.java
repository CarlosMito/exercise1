package br.com.company.banco.exceptions;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.contas.Conta;

// Entendo que semanticamente esta deveria ser uma Checked Exception, porém
// para manter um código mais limpo, preferi deixá-la como um Unchecked Exception.
public class TitularInvallidoException extends RuntimeException {
    public TitularInvallidoException(Cliente titular, Conta conta) {
        super("O cliente do tipo " + titular.getClass().getSimpleName() + " não pode abrir uma conta do tipo " + conta.getClass().getSimpleName());
    }
}