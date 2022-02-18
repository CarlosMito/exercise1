package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.exceptions.TitularInvallidoException;
import br.com.company.banco.interfaces.Depositavel;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements Depositavel {

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Cliente titular) throws TitularInvallidoException {
        super();

        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);

        this.titular = titular;
    }

    public void depositar(double valor) {
        this.depositar(BigDecimal.valueOf(valor));
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}
