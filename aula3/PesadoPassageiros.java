package aula3;

public class PesadoPassageiros extends Veiculo{

	private char carta;
	
	public PesadoPassageiros(Condutor c) {
		super(c,2000,500,35,12000);
		carta = 'D';
	}
	
	public PesadoPassageiros(Condutor dv, int c, int p, int l, int peso) {
		super(dv,c,p,l,peso);
		carta = 'D';		
	}
	
	public boolean podeConduzir(Condutor dv) {
		if(dv.carta() == carta) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Pesado de passageiros";
	}
	
	public String info() {
		return "\nCondutor(a): " +  super.condutor().nome()+
				   "\nNúmero de passageiros: " + passageiros() +
				   "\nCilindrada: " + cilindrada() + " cm3" + 
				   "\nPotência: " + potencia() + " kW" +
				   "\nPeso Bruto: " + peso() + " Kg\n"; 
	}
}
