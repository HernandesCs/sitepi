package br.pi.pojo;

public class Contato {
	
	private String nome;
	private int fone;
	private String email;
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contato(String nome, int fone, String email) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getFone() {
		return fone;
	}
	public void setFone(int fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	}

}
