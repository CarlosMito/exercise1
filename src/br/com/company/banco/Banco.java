package br.com.company.banco;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.contas.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Banco {
    private String nome;

    private final List<Conta> contas = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

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
