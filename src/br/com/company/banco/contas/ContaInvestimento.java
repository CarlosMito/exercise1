package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Cliente titular) {
        super(titular);
    }

    public void adicionar(double valor) {
        this.adicionar(BigDecimal.valueOf(valor));
    }

    public void adicionar(BigDecimal valor) {
        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaRendimento());
        BigDecimal investimento = taxa.multiply(valor).add(valor);
        this.setSaldo(this.saldo.add(investimento));
    }
}
