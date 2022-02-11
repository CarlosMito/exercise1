package br.com.company.banco.contas;

import java.math.BigDecimal;

public class Conta {
    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
