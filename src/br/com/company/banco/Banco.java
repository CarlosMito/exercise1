package br.com.company.banco;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.Conta;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.ArrayList;

// É possível ter um cliente no banco sem conta?

public class Banco {
    private String nome;

    private final ArrayList<Conta> contas = new ArrayList<Conta>();
    private final ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Banco() {
    }

    public void abrirContaCorrente(Cliente cliente) {
        // TODO: Verificar se o CPF é válido
        // Talvez eu altere para essa função ser mais genérica.
        // Porém, ficar atento com os princípios SOLID
        contas.add(new ContaCorrente(cliente));
    }

    public void cadastrarClienteFisico(String endereco, String cpf) {
        this.clientes.add(new ClienteFisico(endereco, cpf))
    }

    public void cadastrarClienteJuridico(String endereco, String cnpj) {
        this.clientes.add(new ClienteJuridico(endereco, cnpj))
    }

    public Conta[] getContas() {
        Conta[] contas = new Conta[this.contas.size()];
        return this.contas.toArray(contas);
    }

    public Cliente[] getClientes() {
        Cliente[] clientes = new Cliente[this.clientes.size()];
        return this.clientes.toArray(clientes);
    }

    public void abrirContaPoupanca() {

    }

    public void abrirContaInvestimento() {

    }

    public BigDecimal sacar(Cliente cliente, Conta conta, BigDecimal valor) throws SaldoInsuficienteException {
        // TODO: Fazer a verificação se o cliente pode ou não sacar da conta

        // NÃO utilizar o construtor do BigDecimal para manter a precisão
        BigDecimal taxa = BigDecimal.valueOf(cliente.getTaxa());
        valor = valor.add(valor.multiply(taxa));

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new SaldoInsuficienteException(valor);

        conta.subtractSaldo(valor);
        return valor;
    }

    public void depositar(Conta conta, BigDecimal valor) throws SaldoInsuficienteException {
        conta.addSaldo(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
