package br.com.company.banco.interfaces;

import java.math.BigDecimal;

public interface Investivel {
    void investir(double valor);
    void investir(BigDecimal valor);
}
