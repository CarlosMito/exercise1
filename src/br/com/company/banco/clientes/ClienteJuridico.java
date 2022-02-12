package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteJuridico extends Cliente {
    private String cnpj;

    public ClienteJuridico() {
        this.taxa = BigDecimal.valueOf(0.5);
    }
}
