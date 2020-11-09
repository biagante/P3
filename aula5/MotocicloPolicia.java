package aula5;

public class MotocicloPolicia extends Motociclo implements Policia {

	private Tipo tipo;
	private String ID;
	
	public MotocicloPolicia(int ano, String cor,int nrodas, int cilindrada,int maxSpeed, String matricula,double consumo, double combustivel, boolean sideCar, Tipo tipo, String ID) {
		super(ano,cor,nrodas,cilindrada, maxSpeed, matricula, consumo, combustivel, sideCar);
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
