package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private String cpf;

    public ContaCorrente() {
        this.saldo = BigDecimal.valueOf(0);
    }

    public ContaCorrente(Cliente titular) {
        super();
        this.titular = titular;
    }
}
