package aula3;

public class Motociclo extends Veiculo {
	
	private boolean sideCar;
	private char carta;
	
	public Motociclo(Condutor c, boolean cart) {
		super(c,125, 11,cart?2:1,140);
		carta = 'A';
		sideCar = cart;
	}
	
	public Motociclo(Condutor dv, int c, int p, int l, int peso) {
		super(dv,c,p,l,peso);
		carta = 'A';
		sideCar = false;
	}
	
	public Motociclo(Condutor c) {
		this(c, false);
	}
	
	public boolean sideCar() {
		return sideCar;
	}
	
	public boolean podeConduzir(Condutor dv) {
		if(dv.carta() == carta) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Motociclo";
	}
	
	public String info() {
		return "\nCondutor(a): " +  super.condutor().nome()+
				   "\nNúmero de passageiros: " + passageiros() +
				   "\nCilindrada: " + cilindrada() + " cm3" + 
				   "\nPotência: " + potencia() + " kW" +
				   "\nPeso Bruto: " + peso() + " Kg" +
				   "\nSideCar: " + (sideCar?"Sim":"Não") + "\n"; 
	}
}
