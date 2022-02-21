package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.exceptions.TitularInvallidoException;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular) throws TitularInvallidoException {
        super(titular);

        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);
    }

    public ContaPoupanca(ContaPoupanca original) {
        super(original);
    }

    @Override
    public Conta copy() {
        return new ContaPoupanca(this);
    }

    @Override
    public void setTitular(Cliente titular) throws TitularInvallidoException {
        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);

        this.titular = titular.copy();
    }

    @Override
    public String toString() {
        return "CONTA POUPANCA\n" + super.toString();
    }
}
