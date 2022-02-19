package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.exceptions.TitularInvallidoException;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular) throws TitularInvallidoException {
        super(titular);

        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);
    }

    @Override
    public void adicionar(double valor) {
        this.adicionar(BigDecimal.valueOf(valor));
    }

    @Override
    public void adicionar(BigDecimal valor) {
        verificarValorNegativo(valor);

        this.saldo = this.saldo.add(valor);
    }

    @Override
    public void setTitular(Cliente titular) throws TitularInvallidoException {
        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, this);

        this.titular = titular;
    }
}
