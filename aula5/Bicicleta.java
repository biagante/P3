package aula5;

public class Bicicleta extends Veiculo {

	private int pneu;
	private String marca;
	
	public Bicicleta(int ano, String cor,int nrodas, int pneu, String marca) {
		super(ano,cor,nrodas);
		this.pneu = pneu;
		this.marca = marca;
	}
	
	public int pneu() {
		return pneu;
	}
	public String marca() {
		return marca;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nBicileta -> Tamanho de pneu: %d, Marca: %s ", pneu,marca);
	}
}
