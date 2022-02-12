package br.com.company.banco.exceptions;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(BigDecimal valor) {
        super("A conta possui saldo inferior a " + valor);
    }
}
