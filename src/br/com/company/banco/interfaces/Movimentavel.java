package br.com.company.banco.interfaces;

import br.com.company.banco.contas.Conta;

import java.math.BigDecimal;

public interface Movimentavel {
    void adicionar(double valor);
    void adicionar(BigDecimal valor);
    void remover(double valor);
    void remover(BigDecimal valor);
    void transferir(Conta favorecido, double valor);
    void transferir(Conta favorecido, BigDecimal valor);
}
