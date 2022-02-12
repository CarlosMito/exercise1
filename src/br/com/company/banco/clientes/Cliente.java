package br.com.company.banco.clientes;

public abstract class Cliente {
    protected String endereco;   // Talvez subdividir em campos, ou criar um tipo próprio
    protected double taxa;       // A taxa NÃO está em %

    public Cliente(String endereco) {
        this.endereco = endereco;
    }

    public double getTaxa() {
        return this.taxa;
    }

    public double setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
