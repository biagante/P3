package aula3;

public class Figura {

	protected Ponto centro;
	
	public Figura(Ponto c) {
		this.centro = c;
	}
	
	public Ponto centro() {
		return centro;
	}
	
	@Override
	public String toString() {
		return "Figura: ";
	}
}
