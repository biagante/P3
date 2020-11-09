package aula5;


public abstract class Veiculo implements Comparable<Veiculo> {

	private int nrodas;
	private String cor;
	private int ano;
	
	public Veiculo(int ano, String cor, int nrodas) {
		this.nrodas = nrodas;
		this.cor = cor;
		this.ano = ano;
	}
	
	//getters
	public int nrodas() {
		return nrodas;
	}
	public String cor() {
		return cor;
	}
	
	public int compareTo(Veiculo v) {
		return this.ano - v.ano;
	}
	
	@Override
	public String toString() {
		return ("Ve�culo -> Ano: "+ano+", N� Rodas: "+nrodas +", Cor: "+cor);
	}
}
