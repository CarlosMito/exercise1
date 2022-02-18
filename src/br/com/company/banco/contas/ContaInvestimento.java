package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;
import br.com.company.banco.interfaces.Investivel;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta implements Investivel {

    public ContaInvestimento() {
        super();
    }

    public ContaInvestimento(Cliente titular) {
        super();
        this.titular = titular;
    }

    public void investir(double valor) {
        this.investir(BigDecimal.valueOf(valor));
    }

    public void investir(BigDecimal valor) {
        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaRendimento());
        BigDecimal investimento = taxa.multiply(valor).add(valor);
        this.setSaldo(this.saldo.add(investimento));
    }
}
