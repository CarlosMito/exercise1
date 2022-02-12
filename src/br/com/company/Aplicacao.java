package br.com.company;

import br.com.company.banco.Banco;
import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.Conta;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public class Aplicacao {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.cadastrarClienteFisico("A", "2022");            // CPF Inválido
        banco.cadastrarClienteFisico("B", "123.456.678-90");  // CPF Inválido
        banco.cadastrarClienteFisico("C", "111.111.111-11");  // CPF Inválido
        banco.cadastrarClienteFisico("D", "386.880.680-62");  // CPF Válido
        banco.cadastrarClienteFisico("E", "124.591.700-50");  // CPF Válido
        banco.cadastrarClienteFisico("F", "33383640086");     // CPF Válido

        banco.cadastrarClienteJuridico("G", "12459170050");         // CNPJ Inválido
        banco.cadastrarClienteJuridico("H", "11.111.111/1111-11");  // CNPJ Inválido
        banco.cadastrarClienteJuridico("I", "12.345.567/8901-23");  // CNPJ Inválido
        banco.cadastrarClienteJuridico("J", "96.942.846/0001-10");  // CNPJ Válido
        banco.cadastrarClienteJuridico("K", "25.133.454/0001-61");  // CNPJ Válido
        banco.cadastrarClienteJuridico("L", "55206945000156");      // CNPJ Válido

        Cliente[] clientes = banco.getClientes();

        // Clientes Físicos
        banco.abrirContaCorrente(clientes[0]);
        banco.abrirContaCorrente(clientes[1]);
        banco.abrirContaPoupanca(clientes[2]);
        banco.abrirContaPoupanca(clientes[3]);
        banco.abrirContaInvestimento(clientes[4]);
        banco.abrirContaInvestimento(clientes[5]);

        // Clientes Jurídicos
        banco.abrirContaCorrente(clientes[6]);
//        banco.abrirContaPoupanca(clientes[7]);  // Vai lançar uma exceção, pois PJ não abre CP
        banco.abrirContaInvestimento(clientes[8]);
        banco.abrirContaCorrente(clientes[9]);

        Conta[] contas = banco.getContas();

        banco.depositar(contas[0],100.00);
        System.out.println(contas[0].getSaldo());
        banco.sacar(contas[0], 50.00);
        System.out.println(contas[0].getSaldo());

        banco.depositar(contas[6], 100.00);
        System.out.println(contas[6].getSaldo());
        banco.sacar(contas[6], 50.00);
        System.out.println(contas[6].getSaldo());

        // Depositar e Investir são muito parecidos
        // Investir = Adicionar dinheiro na Conta Investimento
    }
}
