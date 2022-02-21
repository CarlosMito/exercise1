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

    public ClienteJuridico(ClienteJuridico original) {
        super(original);

        this.cnpj = original.cnpj;
    }

    @Override
    public Cliente copy() {
        return new ClienteJuridico(this);
    }

    @Override
    public String toString() {
        return "CLIENTE JURÍDICO\n" + "CNPJ: " + this.cnpj + '\n' + super.toString();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
