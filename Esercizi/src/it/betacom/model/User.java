package it.betacom.model;

public class User {
	private String nome;
	private String ruolo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public User(String nome,String ruolo) {
		this.nome=nome;
		this.ruolo=ruolo;
	}
	@Override
	public String toString() {
		return "User [nome=" + nome + ", ruolo=" + ruolo + "]";
	}
	
	
}
