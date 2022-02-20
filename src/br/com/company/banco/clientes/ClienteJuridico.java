package br.com.company.banco.clientes;

import java.math.BigDecimal;

public class ClienteJuridico extends Cliente {
    private String cnpj;

    public ClienteJuridico(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.taxaCobranca = 0.005;

        // 2% a mais de rendimento que o de Pessoa Física (1%)
        this.taxaRendimento = 0.1;
    }
}
