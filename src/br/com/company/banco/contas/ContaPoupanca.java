package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Cliente titular) {
        super();
        this.titular = titular;
    }
}
