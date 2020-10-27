package aula3;

public class PesadoMercadorias extends Veiculo{
	
	private char carta;
	

	public PesadoMercadorias(Condutor c) {
		super(c,2000,500,2,12000);
		carta = 'C';
	}
	
	public PesadoMercadorias(Condutor dv, int c, int p, int l, int peso) {
		super(dv,c,p,l,peso);
		carta = 'C';		
	}
	
	public boolean podeConduzir(Condutor dv) {
		if(dv.carta() == carta) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Pesado de mercadorias";
	}
	
	public String info() {
		return "\nCondutor(a): " +  super.condutor().nome()+
				   "\nNúmero de passageiros: " + passageiros() +
				   "\nCilindrada: " + cilindrada() + " cm3" + 
				   "\nPotência: " + potencia() + " kW" +
				   "\nPeso Bruto: " + peso() + " Kg\n"; 
	}
}
