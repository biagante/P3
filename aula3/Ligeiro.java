package aula3;

public class Ligeiro extends Veiculo {

	private char carta;
	
	public Ligeiro(Condutor dv, int c, int p, int l, int peso) {
		super(dv,c,p,l,peso);
		carta = 'B';		
	}
	
	public boolean podeConduzir(Condutor dv) {
		if(dv.carta() == carta) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Ligeiro";
	}
	
	public String info() {
		return "\nCondutor(a): " +  super.condutor().nome()+
				   "\nN�mero de passageiros: " + passageiros() +
				   "\nCilindrada: " + cilindrada() + " cm3" + 
				   "\nPot�ncia: " + potencia() + " kW" +
				   "\nPeso Bruto: " + peso() + " Kg\n"; 
	}
}
