package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico() {
        this.taxa = BigDecimal.valueOf(0);
    }
}
