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

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

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
        Conta[] contas = new Conta[this.contas.size()];
        return this.contas.toArray(contas);
    }

    public Conta[] getContas(String a) {
        Conta[] contasFiltradas = this.contas.stream()
                .filter(conta -> conta instanceof ContaCorrente)
                .toArray(Conta[]::new);

        for (Conta c : contasFiltradas)
            System.out.println(c.getClass());

        Conta[] contas = new Conta[this.contas.size()];
        return this.contas.toArray(contas);
    }

    public Cliente[] getClientes() {
        Cliente[] clientes = new Cliente[this.clientes.size()];
        return this.clientes.toArray(clientes);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
