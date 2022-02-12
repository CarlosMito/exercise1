package br.com.company.banco.contas;

import java.math.BigDecimal;

public abstract class Conta {
    protected BigDecimal saldo;

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
}
