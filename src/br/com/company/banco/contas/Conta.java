package br.com.company.banco.contas;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public abstract class Conta {
    protected BigDecimal saldo;
    protected Cliente titular;

    public Conta() {
        this.saldo = BigDecimal.valueOf(0);
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        // NÃO utilizar o construtor do BigDecimal (para manter a precisão)
        BigDecimal taxa = BigDecimal.valueOf(this.titular.getTaxaCobranca());
        BigDecimal BDValor = BigDecimal.valueOf(valor);
        BDValor = BDValor.add(BDValor.multiply(taxa));

        if (this.saldo.compareTo(BDValor) < 0)
            throw new SaldoInsuficienteException(BDValor);

        this.saldo = this.saldo.subtract(BDValor);
    }

    public void consultarSaldo() {
        System.out.printf("Saldo: R$%.2f\n" , this.saldo);
    }

    public void depositar(double valor) {
        this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void transferir(Conta favorecido, double valor) {
        this.sacar(valor);
        favorecido.depositar(valor);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(BigDecimal valor) {
        setSaldo(this.saldo.add(valor));
    }

    public void subtractSaldo(BigDecimal valor) {
        setSaldo(this.saldo.subtract(valor));
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
