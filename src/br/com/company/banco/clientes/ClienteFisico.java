package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
        this.taxaCobranca = 0.0;
        this.taxaRendimento = 0.08;
    }

    @Override
    public String toString() {
        return "CLIENTE FÍSICO\n" + "CPF: " + this.cpf + '\n' + super.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
