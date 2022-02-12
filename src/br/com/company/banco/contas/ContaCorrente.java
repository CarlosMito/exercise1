package br.com.company.banco.contas;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    public ContaCorrente() {
        this.saldo = BigDecimal.valueOf(0);
    }
}
