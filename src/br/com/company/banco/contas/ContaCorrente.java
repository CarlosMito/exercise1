package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;
import br.com.company.banco.interfaces.Depositavel;

import java.math.BigDecimal;

public class ContaCorrente extends Conta implements Depositavel {
    private String cpf;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(Cliente titular) {
        super();
        this.titular = titular;
    }

    public void depositar(double valor) {
        this.depositar(BigDecimal.valueOf(valor));
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}
