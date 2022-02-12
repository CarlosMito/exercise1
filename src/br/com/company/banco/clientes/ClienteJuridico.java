package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteJuridico extends Cliente {
    private String cnpj;

    public ClienteJuridico(String endereco, String cnpj) {
        super(endereco);
        this.cnpj = cnpj;
        this.taxa = 0.005;
    }
}
