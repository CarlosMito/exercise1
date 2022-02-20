package br.com.company.banco.clientes;

public abstract class Cliente {
    protected String nome;
    protected String endereco;           // Talvez subdividir em campos, ou criar um tipo próprio
    protected double taxaCobranca;       // A taxa NÃO está em %
    protected double taxaRendimento;     // A taxa NÃO está em %

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    // TODO: Rever encapsulamento dos getters e setters de instâncias

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxaCobranca() {
        return this.taxaCobranca;
    }

    public void setTaxaCobranca(double TaxaCobranca) {
        this.taxaCobranca = TaxaCobranca;
    }

    public double getTaxaRendimento() {
        return this.taxaRendimento;
    }

    public void setTaxaRendimento(double TaxaRendimento) {
        this.taxaRendimento = TaxaRendimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
