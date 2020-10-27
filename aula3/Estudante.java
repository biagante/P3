package aula3;

public class Estudante extends Pessoa{

	static int currentNmec = 100;
	final int nmec;
	final Data dataInsc;
	
	public Estudante(String nome, int cc, Data nasc, Data insc) {
		super(nome, cc, nasc);
		this.nmec = currentNmec++;
		this.dataInsc = insc;
		
	}
	//caso não seja introduzida d.inscrição, assume d.atual
	public Estudante(String nome, int cc, Data nasc) {
		super(nome, cc, nasc);
		this.nmec = currentNmec++;
		this.dataInsc = new Data(); 
	}
	
	public int nmec() {
		return nmec;
	}
	public Data dataInsc() {
		return dataInsc;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", NMec: " + nmec + ", inscrito em \nData: " + dataInsc; 
	}
	
}