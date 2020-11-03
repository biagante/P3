package aula4;

public class Professor extends Pessoa{
	
	private int num_func = 1;
	private int nfunc;
	private Data admiss;
	
	public Professor(String nome, int cc, Data nasc) {
		super(nome, cc, nasc);
		this.nfunc = num_func++;
		this.admiss = new Data();
	}
	
	@Override
	public String toString() {
		return "PROFESSOR: " + super.toString() + ", nMec: " +nfunc + ", Admitido em Data: " + admiss + "\n";
	}
}
