package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(Cliente titular) {
        super();
        this.titular = titular;
    }

    public void investir(double valor) throws SaldoInsuficienteException {
        BigDecimal BDValor = BigDecimal.valueOf(valor);

        if (this.saldo.compareTo(BDValor) < 0)
            throw new SaldoInsuficienteException(BDValor);

        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaRendimento());
        this.depositar(taxa.multiply(BigDecimal.valueOf(valor)));
    }
}
