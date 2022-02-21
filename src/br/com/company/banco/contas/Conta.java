package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.*;
import br.com.company.banco.interfaces.Movimentavel;

import java.math.BigDecimal;

public abstract class Conta implements Movimentavel {
    protected BigDecimal saldo;
    protected Cliente titular;

    public Conta(Cliente titular) throws ContaSemTitularException {
        if (titular == null)
            throw new ContaSemTitularException();

        this.titular = titular.copy();
        this.saldo = BigDecimal.valueOf(0);
    }

    public Conta(Conta original) {
        // Como não é permitido a instanciação de uma Conta com o titular nulo,
        // acredito que não seja necessário verificar isso aqui

        this.titular = original.titular.copy();
        this.saldo = original.saldo;
    }

    abstract public Conta copy();

    @Override
    public void remover(double valor) throws SaldoInsuficienteException {
        // NÃO utilizar o construtor do BigDecimal (para manter a precisão)
        this.remover(BigDecimal.valueOf(valor));
    }

    @Override
    public void remover(BigDecimal valor) {
        bloquearValorNegativo(valor);

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
        if (favorecido == this)
            throw new TransferenciaParaMesmaContaException();

        bloquearValorNegativo(valor);

        this.remover(valor);
        BigDecimal saldo = favorecido.getSaldo();
        favorecido.setSaldo(saldo.add(valor));
    }

    @Override
    public void adicionar(double valor) {
        this.adicionar(BigDecimal.valueOf(valor));
    }

    @Override
    public void adicionar(BigDecimal valor) {
        bloquearValorNegativo(valor);

        this.saldo = this.saldo.add(valor);
    }

    protected static void bloquearValorNegativo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new OperacaoComValorNegativoException();
    }

    public String getSaldoFormatado() {
        return String.format("R$%.2f", this.saldo);
    }

    // Como BigDecimal e String são imutáveis, não é preciso se preocupar com os getters e setters.
    public BigDecimal getSaldo() {
        return saldo;
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return this.titular.copy();
    }

    public void setTitular(Cliente titular) {
        this.titular = titular.copy();
    }

    @Override
    public String toString() {
        return "Titular: " + this.titular.getNome() + '\n' +
                "Saldo: " + this.getSaldoFormatado();
    }

}
