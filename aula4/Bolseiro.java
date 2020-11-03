package aula4;

public class Bolseiro extends Estudante{
	
	private int bolsa;
	
	public Bolseiro(String nome, int cc, Data nasc, Data insc) {
		super(nome,cc,nasc,insc);
	}
	public Bolseiro(String nome, int cc, Data nasc) {
		super(nome, cc, nasc);
	}
	
	public int bolsa() {
		return bolsa;
	}
	
	public void setBolsa(int stock) {
		this.bolsa = stock;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Bolseiro com bolsa de " + bolsa + " euros";
	}
}
