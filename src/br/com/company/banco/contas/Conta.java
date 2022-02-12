package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public abstract class Conta {
    protected BigDecimal saldo;
    protected Cliente titular;

    public Conta() {
        this.saldo = BigDecimal.valueOf(0);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(BigDecimal valor) {
        setSaldo(this.saldo.add(valor));
    }

    public void subtractSaldo(BigDecimal valor) {
        setSaldo(this.saldo.subtract(valor));
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
