package aula4;

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
	
	public int nMec() {
		return nmec;
	}
	public Data dataInsc() {
		return dataInsc;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Estudante NMec: " + nmec + ", Inscrito em Data: " + dataInsc; 
	}
	
}