package aula5;


public class Motociclo extends Motorizado{
	
	private boolean sideCar;
	
	public Motociclo(int ano, String cor,int nrodas, int cilindrada,int maxSpeed, String matricula,double consumo, double combustivel, boolean sideCar) {
		super(ano,cor,nrodas,cilindrada, maxSpeed, matricula, consumo,combustivel);
		this.sideCar = sideCar;
	}
	
	
	public boolean sideCar() {
		return sideCar;
	}
	
	@Override
	public String toString() {
		return super.toString() + ("\nMotociclo -> Side car: " + (sideCar?"Sim":"Não"));
	}
}
