package br.com.company.banco.interfaces;

import br.com.company.banco.contas.Conta;

public interface Movimentavel {
    void sacar(double valor);
    void transferir(Conta favorecido, double valor);
}
