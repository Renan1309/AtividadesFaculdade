package br.edu.fbv.modelos;

public class Eleitor {
	private long id ;
	private int TituloEleitor ;
	private String nome ;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTituloEleitor() {
		return TituloEleitor;
	}
	public void setTituloEleitor(int tituloEleitor) {
		TituloEleitor = tituloEleitor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
