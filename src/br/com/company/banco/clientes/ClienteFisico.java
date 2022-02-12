package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String endereco, String cpf) {
        // TODO: Verificar se o CPF é válido

        super(endereco);
        this.cpf = cpf;
        this.taxaCobranca = 0.0;
        this.taxaRendimento = 0.01;
    }
}
