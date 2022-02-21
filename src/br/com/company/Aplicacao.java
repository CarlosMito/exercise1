/**
 * Autor: Carlos Mito
 * Este programa simula uma aplicação bancária (beeem) simplificada.
 *
 * Funcionalidades:
 *   - Abertura de conta;
 *   - Saque;
 *   - Depósito;
 *   - Transferência;
 *   - Investimento;
 *   - Consulta de saldo.
 *
 * De maneira geral, não foram implementados métodos para a modificação dos elementos
 * dentro do banco, contudo, as regras de encapsulamento foram levadas em consideração.
 * Portanto, com exceção do retorno da lista de contas e clientes pela classe Banco,
 * os demais atributos respeitam o encapsulamento.
 *
 * As funções implementadas na classe [Aplicacao] foram criadas, exclusivamente,
 * para demonstrar as funcionalidades do banco como um todo.
 *
 * Algumas considerações adicionais foram deixadas nos comentários do código
 * para auxiliar na correção do projeto e na avaliação pelo professor.
 *
 */

package br.com.company;

import br.com.company.banco.Banco;
import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.Conta;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.contas.ContaInvestimento;
import br.com.company.banco.contas.ContaPoupanca;
import br.com.company.banco.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public class Aplicacao {
    public static void main(String[] args) {
        Banco banco = new Banco("Rings");

        abrirContaParaCadaCliente(banco, gerarClientes());

        Conta[] contas = banco.getContas();

        Conta ultimaConta = contas[0];

        for (Conta conta : contas) {
            testarDepositoInvestimento(conta, 100.0);
            testarSaque(conta, 100.0);

            conta.adicionar(100.0);

            testarTransferencia(conta, ultimaConta, 50.0);
            ultimaConta = conta;
        }

        testarDepositoInvestimento(contas[0], -1000.0);
        testarSaque(contas[0], -10.0);
        testarTransferencia(contas[0], contas[1], -50.0);
        testarTransferencia(contas[0], contas[1], 1000.0);
    }

    public static Cliente[] gerarClientes() {
        return new Cliente[] {
                new ClienteFisico("Amanda", "A", "386.880.680-62"),
                new ClienteFisico("Bruno", "B", "124.591.700-50"),
                new ClienteFisico("Carlos", "C", "333.836.400-86"),
                new ClienteJuridico("Daniela", "D", "96.942.846/0001-10"),
                new ClienteJuridico("Emanuel", "E", "25.133.454/0001-61"),
                new ClienteJuridico("Fernanda", "F", "55.206.945/0001-56")
        };
    }

    public static void abrirContaParaCadaCliente(Banco banco, Cliente[] clientes) {
        List<Function<Cliente, Conta>> construtores = new ArrayList<>();

        construtores.add(ContaCorrente::new);
        construtores.add(ContaPoupanca::new);
        construtores.add(ContaInvestimento::new);

        for (int i = 0; i < clientes.length; i++) {
            try {
                Conta novaConta = construtores.get(i % construtores.size()).apply(clientes[i]);
                banco.abrirConta(novaConta);
                System.out.println(clientes[i].getNome() + " (" + clientes[i].getClass().getSimpleName() +
                        ") abriu uma nova conta (" + novaConta.getClass().getSimpleName() + ")");
            } catch (TitularInvallidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void imprimirInfoContas(Conta[] contas) {
        int counter = 1;

        for (Conta conta : contas) {
            System.out.println("INSTÂNCIA " + counter++);
            System.out.println("Conta: " + conta.getClass().getSimpleName());
            System.out.println("Cliente: " + conta.getTitular().getClass().getSimpleName());
            System.out.println("Titular: " + conta.getTitular().getNome() + "\n");
        }
    }

    private static void imprimirCabecalho(String texto) {
        System.out.println();
        System.out.println("===================================================");
        System.out.println(texto);
        System.out.println("===================================================");
    }

    public static void testarDepositoInvestimento(Conta conta, double valor) {
        Map<Class<?>, String> operacao = Map.of(
            ContaPoupanca.class, "Depositando",
            ContaCorrente.class, "Depositando",
            ContaInvestimento.class, "Investindo"
        );

        imprimirCabecalho("TESTE DEPÓSITO/INVESTIMENTO");
        imprimirInfoContas(new Conta[] {conta});

        System.out.println("Saldo inicial: " + conta.getSaldoFormatado() + '\n');
        System.out.printf("%s R$%.2f\n", operacao.get(conta.getClass()), valor);

        try {
            conta.adicionar(valor);
            System.out.println("Operação realizada com sucesso!");
        } catch (OperacaoComValorNegativoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\nSaldo final: " + conta.getSaldoFormatado());
    }

    public static void testarSaque(Conta conta, double valor) {
        imprimirCabecalho("TESTE SAQUE");
        imprimirInfoContas(new Conta[] {conta});

        System.out.println("Saldo inicial: " + conta.getSaldoFormatado() + '\n');
        System.out.printf("Sacando R$%.2f\n", valor);

        try {
            conta.remover(valor);
            System.out.println("Operação realizada com sucesso!");
        } catch (SaldoInsuficienteException | OperacaoComValorNegativoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\nSaldo final: " + conta.getSaldoFormatado());
    }

    public static void testarTransferencia(Conta debitado, Conta favorecido, double valor) {
        imprimirCabecalho("TESTE TRANSFERÊMCIA");
        imprimirInfoContas(new Conta[] {debitado, favorecido});

        System.out.println("Saldo inicial (DEBITADO): " + debitado.getSaldoFormatado());
        System.out.println("Saldo inicial (FAVORECIDO): " + favorecido.getSaldoFormatado() + '\n');
        System.out.printf("Transferindo R$%.2f (%s para %s)\n", valor, debitado.getTitular().getNome(), favorecido.getTitular().getNome());

        try {
            debitado.transferir(favorecido, valor);
            System.out.println("Operação realizada com sucesso!");
        } catch (SaldoInsuficienteException | OperacaoComValorNegativoException | TransferenciaParaMesmaContaException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\nSaldo final (DEBITADO): " + debitado.getSaldoFormatado());
        System.out.println("Saldo final (FAVORECIDO): " + favorecido.getSaldoFormatado());
    }
}
