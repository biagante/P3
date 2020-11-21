package aula7;

public class Companhia {
	private String sigla;
	private String nome;
	
	public Companhia(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public String sigla() {
		return sigla;
	}
	public String nome() {
		return nome;
	}
	
	public String toString() {
		return nome;
	}
}
