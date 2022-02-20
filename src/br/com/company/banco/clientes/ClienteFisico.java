package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String nome, String endereco, String cpf) {
        // TODO: Verificar se o CPF é válido

        super(nome, endereco);
        this.cpf = cpf;
        this.taxaCobranca = 0.0;
        this.taxaRendimento = 0.08;
    }
}
