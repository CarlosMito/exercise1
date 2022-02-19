package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.ContaSemTitularException;
import br.com.company.banco.exceptions.OperacaoComValorNegativoException;
import br.com.company.banco.exceptions.SaldoInsuficienteException;
import br.com.company.banco.interfaces.Movimentavel;

import java.math.BigDecimal;

public abstract class Conta implements Movimentavel {
    protected BigDecimal saldo;
    protected Cliente titular;

    public Conta(Cliente titular) throws ContaSemTitularException {
        if (titular == null)
            throw new ContaSemTitularException();

        this.titular = titular;
        this.saldo = BigDecimal.valueOf(0);
    }

    @Override
    public void remover(double valor) throws SaldoInsuficienteException {
        // NÃO utilizar o construtor do BigDecimal (para manter a precisão)
        this.remover(BigDecimal.valueOf(valor));
    }

    @Override
    public void remover(BigDecimal valor) {
        this.verificarValorNegativo(valor);

        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaCobranca());
        valor = valor.add(valor.multiply(taxa));

        if (this.saldo.compareTo(valor) < 0)
            throw new SaldoInsuficienteException(valor);

        this.saldo = this.saldo.subtract(valor);
    }

    @Override
    public void transferir(Conta favorecido, double valor) {
        this.transferir(favorecido, BigDecimal.valueOf(valor));
    }

    @Override
    public void transferir(Conta favorecido, BigDecimal valor) {
        verificarValorNegativo(valor);

        this.remover(valor);
        BigDecimal saldo = favorecido.getSaldo();
        favorecido.setSaldo(saldo.add(valor));
    }

    protected static void verificarValorNegativo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new OperacaoComValorNegativoException();
    }

    public void consultarSaldo() {
        System.out.printf("Saldo: R$%.2f\n" , this.saldo);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    // TODO: Adicioanar toString
}
