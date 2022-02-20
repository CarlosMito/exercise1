package br.com.company.banco.exceptions;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(BigDecimal valor) {
        super(String.format("A conta possui saldo inferior a R$%.2f", valor));
    }
}
