package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private String cpf;

    public ContaCorrente(Cliente titular) {
        super(titular);
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
}
