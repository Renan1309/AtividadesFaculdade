package br.edu.fbv.modelos;

public class Candidato {
	private long id;
	private int numerodeeleicao;
	private String nome ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumerodeeleicao() {
		return numerodeeleicao;
	}
	public void setNumerodeeleicao(int numerodeeleicao) {
		this.numerodeeleicao = numerodeeleicao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
