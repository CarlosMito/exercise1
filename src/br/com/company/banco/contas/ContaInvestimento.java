package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Cliente titular) {
        super(titular);
    }

    public ContaInvestimento(ContaInvestimento original) {
        super(original);
    }

    @Override
    public Conta copy() {
        return new ContaInvestimento(this);
    }

    @Override
    public void adicionar(double valor) {
        this.adicionar(BigDecimal.valueOf(valor));
    }

    @Override
    public void adicionar(BigDecimal valor) {
        bloquearValorNegativo(valor);

        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaRendimento());
        BigDecimal investimento = taxa.multiply(valor).add(valor);
        this.setSaldo(this.saldo.add(investimento));
    }

    @Override
    public String toString() {
        return "CONTA INVESTIMENTO\n" + super.toString();
    }
}
