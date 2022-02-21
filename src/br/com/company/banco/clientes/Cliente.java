package br.com.company.banco.clientes;

public abstract class Cliente {
    protected String nome;
    protected String endereco;

    protected double taxaCobranca;       // A taxa NÃO está em %
    protected double taxaRendimento;     // A taxa NÃO está em %

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente(Cliente original) {
        // Esse construtor é utilizado para criar uma cópia de [original]
        // Tem como objetivo preservar o encapsulamento de objetos que o referenciam

        this.nome = original.nome;
        this.endereco = original.endereco;
        this.taxaCobranca = original.taxaCobranca;
        this.taxaRendimento = original.taxaRendimento;
    }

    // Não vou utilizar a interface Cloneable sobrescrevendo o método [Object clone()],
    // pois vi que trás diversos problemas. Ao invés disso, irei criar um método próprio
    // com outro assinatura, e chamar o Copy Constructor dentro dela.
    abstract public Cliente copy();

    // TODO: Remover importações inúteis e adicionar comentários úteis

    @Override
    public String toString() {
        return "Nome: " + this.nome + '\n' +
                "Endereco: " + this.endereco + '\n' +
                "Taxa de Cobrança: " + this.taxaCobranca * 100 + "%\n" +
                "Taxa de Rendimento: " + this.taxaRendimento * 100 + "%";
    }

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
