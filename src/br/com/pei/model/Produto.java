package br.com.pei.model;

public class Produto {
	private String codigoDeBarras;
	private String nome;
	private double preco;
	private int quantidadeEmEstoque;
	private String descricao;
	
	public Produto(String codigoDeBarras, String nome, double preco, int quantidadeEmEstoque, String descricao) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.descricao = descricao;
		
	}

	public String getCodigoDeBarras() {return codigoDeBarras;}
	public void setCodigoDeBarras(String codigoDeBarras) {this.codigoDeBarras = codigoDeBarras;}
	public String getNome() { return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public double getPreco() {return preco;}
	public void setPreco(double preco) {this.preco = preco;}
	public int getQuantidadeEmEstoque() {return quantidadeEmEstoque;}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {this.quantidadeEmEstoque = quantidadeEmEstoque;}
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	
	@Override
	public String toString() {
		return "Produto [código =" + codigoDeBarras + ", nome =" + nome + ", preço =" + preco + ", quantidade =" + quantidadeEmEstoque + ", descrição =" + descricao + "]";
	}
}
