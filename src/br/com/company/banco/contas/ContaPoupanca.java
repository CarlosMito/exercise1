package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.exceptions.TitularInvallidoException;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente titular) throws TitularInvallidoException {
        super();

        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);

        this.titular = titular;
    }
}
