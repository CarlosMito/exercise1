package br.com.company.banco;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.Conta;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.contas.ContaInvestimento;
import br.com.company.banco.contas.ContaPoupanca;
import br.com.company.banco.exceptions.SaldoInsuficienteException;
import br.com.company.banco.exceptions.TitularInvallidoException;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

public class Banco {
    private String nome;

    private final List<Conta> contas = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    public Banco() {}

    public Banco(String nome) {
        this.nome = nome;
    }

    public void abrirConta(Conta conta) {
        if (!clientes.contains(conta.getTitular()))
            this.clientes.add(conta.getTitular());

        this.contas.add(conta);
    }

    public Conta[] getContas() {
        return this.contas.toArray(Conta[]::new);
    }

    public Conta[] getContasFiltrandoPor(Predicate<? super Conta> filter) {
        return this.contas.stream()
                .filter(filter)
                .toArray(Conta[]::new);
    }

    public Cliente[] getClientes() {
        return this.clientes.toArray(Cliente[]::new);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
