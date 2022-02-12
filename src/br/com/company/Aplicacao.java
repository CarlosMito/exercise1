package br.com.company;

import br.com.company.banco.Banco;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.Conta;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public class Aplicacao {
    public static void main(String[] args) {
        System.out.println("Carlos");

        Banco banco = new Banco();


        banco.cadastrarClienteFisico("A", "123.456.678-90");  // CPF Inválido
        banco.cadastrarClienteFisico("B", "111.111.111-11");  // CPF Inválido
        banco.cadastrarClienteFisico("C", "222.222.222-22");  // CPF Inválido
        banco.cadastrarClienteFisico("D", "386.880.680-62");  // CPF Válido
        banco.cadastrarClienteFisico("E", "124.591.700-50");  // CPF Válido
        banco.cadastrarClienteFisico("F", "333.836.400-86");  // CPF Válido

        Conta[] contas = banco.getContas();

        banco.depositar(contas[0], BigDecimal.valueOf(100.00));

        System.out.println(contas[0].getSaldo());

        banco.sacar(new ClienteJuridico("", ""), contas[0], BigDecimal.valueOf(50.0));

        System.out.println(contas[0].getSaldo());

        // Depositar e Investir são muito parecidos
        // Investir = Adicionar dinheiro na Conta Investimento
    }
}
