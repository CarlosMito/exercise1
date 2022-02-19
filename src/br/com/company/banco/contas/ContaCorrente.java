package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private String cpf;

    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    public void adicionar(double valor) {
        this.adicionar(BigDecimal.valueOf(valor));
    }

    public void adicionar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}
