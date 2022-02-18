package br.com.company.banco.interfaces;

import java.math.BigDecimal;

public interface Depositavel {
    void depositar(double valor);
    void depositar(BigDecimal valor);
}
