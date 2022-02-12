package br.com.company.banco;

import br.com.company.banco.clientes.Cliente;
import br.com.company.banco.contas.Conta;

import java.util.ArrayList;

public class Banco {
    private String nome;

    private ArrayList<Conta> contas;
    private ArrayList<Cliente> clientes;

    public Banco() {

    }

    public void abrirContaCorrente() {

    }

    public void abrirContaPoupanca() {

    }

    public void abrirContaInvestimento() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
