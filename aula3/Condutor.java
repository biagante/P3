package aula3;

public class Condutor extends Pessoa{

	private char carta;
	
	public Condutor(String nome, int cc, Data nasc, char c) {
		super(nome, cc, nasc);
		this.carta = c;
	}
	
	public char carta() {
		return carta;
	}
	
	

}
