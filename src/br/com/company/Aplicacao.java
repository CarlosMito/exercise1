/**
 * Este programa simula uma aplicação bancária.
 *
 * Funcionalidades:
 *   [x] Abertura de conta;
 *   [x] Saque;
 *   [x] Depósito;
 *   [x] Transferência;
 *   [x] Investimento;
 *   [x] Consulta de saldo.
 *
 * Autor: Carlos Mito
 *
 * Algumas considerações foram deixadas nos comentários para auxiliar na correção do projeto.
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


public class Aplicacao {
    public static void main(String[] args) {
        Banco banco = new Banco();

        abrirContaParaCadaCliente(banco, gerarClientes());

        banco.getContas("a");

    }

    public static Cliente[] gerarClientes() {
        return new Cliente[] {
                new ClienteFisico("A", "-", "2022"),                  // CPF Inválido
                new ClienteFisico("B", "-", "123.456.678-90"),        // CPF Inválido
                new ClienteFisico("C", "-", "111.111.111-11"),        // CPF Inválido
                new ClienteFisico("D", "-", "386.880.680-62"),        // CPF Válido
                new ClienteFisico("E", "-", "124.591.700-50"),        // CPF Válido
                new ClienteFisico("F", "-", "33383640086"),           // CPF Válido

                new ClienteJuridico("G", "-", "12459170050"),         // CNPJ Inválido
                new ClienteJuridico("H", "-", "11.111.111/1111-11"),  // CNPJ Inválido
                new ClienteJuridico("I", "-", "12.345.567/8901-23"),  // CNPJ Inválido
                new ClienteJuridico("J", "-", "96.942.846/0001-10"),  // CNPJ Válido
                new ClienteJuridico("K", "-", "25.133.454/0001-61"),  // CNPJ Válido
                new ClienteJuridico("L", "-", "55206945000156")       // CNPJ Válido
        };
    }

    public static void abrirContaParaCadaCliente(Banco banco, Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i += 3) {
            banco.abrirConta(new ContaCorrente(clientes[i]));

            // Evita que um ClienteJuridico abra uma ContaPoupanca
            banco.abrirConta(i < 6 ? new ContaPoupanca(clientes[i + 1]) : new ContaInvestimento(clientes[i + 1]));

            banco.abrirConta(new ContaInvestimento(clientes[i + 2]));
        }
    }

    public static void testarDeposito(Conta[] contas) {

    }

    public static void testarInvestimento(Conta[] contas) {

    }

    public static void testarSaque(Conta[] contas) {

    }

    public static void testarTransferencia(Conta[] contas) {

    }

    public static void test() {
        Banco banco = new Banco();


        Conta[] contas = banco.getContas();

        ContaCorrente corrente = (ContaCorrente) contas[0];
        ContaPoupanca poupanca = (ContaPoupanca) contas[4];

        corrente.adicionar(100.00);
        corrente.remover(50.00);

        poupanca.adicionar(100.00);
        poupanca.remover(50.00);

        System.out.println(contas[0].getSaldo());
        System.out.println(contas[4].getSaldo());
        contas[4].transferir(contas[0], 10.0);
        System.out.println(contas[0].getSaldo());
        System.out.println(contas[4].getSaldo());

        ContaInvestimento investimento1 = (ContaInvestimento) contas[2];
        ContaInvestimento investimento2 = (ContaInvestimento) contas[5];
        ContaInvestimento investimento3 = (ContaInvestimento) contas[8];

        investimento1.adicionar(100.0);
        investimento2.adicionar(100.0);
        investimento3.adicionar(100.0);
        investimento3.adicionar(103.0);
        investimento3.adicionar(106.09);

        investimento1.consultarSaldo();
        investimento2.consultarSaldo();
        investimento3.consultarSaldo();

        // Depositar e Investir são muito parecidos
        // Investir = Adicionar dinheiro na Conta Investimento
    }
}
