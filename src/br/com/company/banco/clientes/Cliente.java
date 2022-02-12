package br.com.company.banco.clientes;

import br.com.company.banco.contas.Conta;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public abstract class Cliente {
    protected String endereco;
    protected BigDecimal taxa;

    public BigDecimal sacar(BigDecimal valor, Conta conta) throws SaldoInsuficienteException {
        if (conta.getSaldo().compareTo(valor) < 0)
            throw new SaldoInsuficienteException(valor);

        BigDecimal taxa = valor.multiply(this.taxa);
        conta.subtractSaldo(valor.add(taxa));
        return valor;
    }

    public int depositar(BigDecimal valor, Conta conta) {
        return 0;
    }


}
