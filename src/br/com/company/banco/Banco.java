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

import java.math.BigDecimal;
import java.util.ArrayList;

// É possível ter um cliente no banco sem conta?

public class Banco {
    private String nome;

    private final ArrayList<Conta> contas = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();

    public Banco() {}

    public void abrirContaCorrente(Cliente titular) {
        // Talvez eu altere para essa função ser mais genérica.
        // Porém, ficar atento com os princípios SOLID
        contas.add(new ContaCorrente(titular));
    }

    public void abrirContaPoupanca(Cliente titular) {
        if (titular instanceof ClienteJuridico)
            throw new TitularInvallidoException(titular, new ContaPoupanca());

        contas.add(new ContaPoupanca(titular));
    }

    public void abrirContaInvestimento(Cliente titular) {
        contas.add(new ContaInvestimento(titular));
    }

    public void cadastrarClienteFisico(String endereco, String cpf) {
        this.clientes.add(new ClienteFisico(endereco, cpf));
    }

    public void cadastrarClienteJuridico(String endereco, String cnpj) {
        this.clientes.add(new ClienteJuridico(endereco, cnpj));
    }

    public Conta[] getContas() {
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
