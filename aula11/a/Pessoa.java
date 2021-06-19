package aula11.a;

public class Pessoa{
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data nasc) {
		this.nome = nome;
		this.cc = cc;
		dataNasc = nasc;
	}
	
	public String nome() {
		return nome;
	}
	public int cc() {
		return cc;
	}
	public Data dataNasc() {
		return dataNasc;
	}
	@Override
	public String toString() {
		return (nome + ", BI: " + cc + ", Nascido na Data: " + dataNasc);
	}
}