package br.com.company;

import br.com.company.banco.Banco;
import br.com.company.banco.clientes.ClienteFisico;
import br.com.company.banco.clientes.ClienteJuridico;
import br.com.company.banco.contas.ContaCorrente;
import br.com.company.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public class Aplicacao {
    public static void main(String[] args) {
        System.out.println("Carlos");

        Banco banco = new Banco();

        ContaCorrente conta1 = new ContaCorrente();
        ClienteJuridico jud1 = new ClienteJuridico();
        ClienteFisico fis1 = new ClienteFisico();

        System.out.println(conta1.getSaldo());
        conta1.addSaldo(BigDecimal.valueOf(10.12));

        try {
            jud1.sacar(BigDecimal.valueOf(20), conta1);
        } catch (SaldoInsuficienteException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(conta1.getSaldo());

        // Depositar e Investir são muito parecidos
        // Investir = Adicionar dinheiro na Conta Investimento
    }
}
