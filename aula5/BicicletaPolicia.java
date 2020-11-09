package aula5;

public class BicicletaPolicia extends Bicicleta implements Policia {
	
	private Tipo tipo;
	private String ID;
	
	public BicicletaPolicia(int ano, String cor,int nrodas, int pneu, String marca, Tipo tipo, String ID) {
		super(ano,cor,nrodas,pneu,marca);
		this.tipo = tipo;
		this.ID = ID;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	public String getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\nTipo: "+ tipo + (" | ") + "ID: "+ ID;
	}

}
