package aula5;

public class AutomovelPolicia extends Automovel implements Policia {

	private Tipo tipo;
	private String ID;	
	
	public AutomovelPolicia(int ano, String cor,int nrodas, int cilindrada,int maxSpeed, String matricula,double consumo, double combustivel, int lugares, boolean atrelado, Tipo tipo, String ID) {
		super(ano,cor,nrodas,cilindrada, maxSpeed, matricula, consumo,combustivel, lugares, atrelado);
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
