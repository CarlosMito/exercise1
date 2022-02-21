package br.com.company.banco.clientes;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
        this.taxaCobranca = 0.0;
        this.taxaRendimento = 0.08;
    }

    public ClienteFisico(ClienteFisico original) {
        super(original);

        this.cpf = original.cpf;
    }

    @Override
    public Cliente copy() {
        return new ClienteFisico(this);
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
