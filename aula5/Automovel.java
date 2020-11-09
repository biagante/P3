package aula5;

public class Automovel extends Motorizado {

	private int lugares;
	private boolean atrelado;
	
	public Automovel(int ano, String cor,int nrodas, int cilindrada,int maxSpeed, String matricula,double consumo, double combustivel, int lugares, boolean atrelado) {
		super(ano,cor,nrodas,cilindrada,maxSpeed,matricula,consumo,combustivel);
		this.lugares = lugares;
		this.atrelado = atrelado;
	}
	
	public int lugares() {
		return lugares;
	}
	public boolean atrelado() {
		return atrelado;
	}
	
	@Override
	public String toString() {
		return super.toString() + ("\nAutomóvel -> Nº de lugares: "+ lugares+", Atrelado: "+ (atrelado?"Sim":"Não"));
	}
}
