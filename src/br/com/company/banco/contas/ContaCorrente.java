package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    public ContaCorrente(ContaCorrente original) {
        super(original);
    }

    @Override
    public Conta copy() {
        return new ContaCorrente(this);
    }

    @Override
    public String toString() {
        return "CONTA CORRENTE\n" + super.toString();
    }
}
