package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String endereco, String cpf) {
        super(endereco);
        this.cpf = cpf;
        this.taxa = 0.0;
    }
}
