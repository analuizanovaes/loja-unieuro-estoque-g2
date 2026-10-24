package br.unieuro.estoque.modelo;

public class Produto {

    private int id;
    private String nome;
    private int quantidadeAtual;
    private int estoqueMinimo;

    public Produto(int id, String nome, int quantidadeAtual, int estoqueMinimo) {
        
        this.id = id;
        this.nome = nome;
        this.quantidadeAtual = quantidadeAtual;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidadeAtual() { return quantidadeAtual; }
    public int getEstoqueMinimo() { return estoqueMinimo; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setQuantidadeAtual(int quantidadeAtual) { this.quantidadeAtual = quantidadeAtual; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }
    
    public boolean isAbaixoDoMinimo() {
        return this.quantidadeAtual < this.estoqueMinimo;
    }

    public String getStatusAlerta() {

        if (this.quantidadeAtual == 0) {
            return "ESGOTADO";
        }
        return "ESTOQUE CRÍTICO";
    }
}