package aula4;

public abstract class Figura {

	protected Ponto centro;
	
	public Figura(Ponto c) {
		this.centro = c;
	}
	
	public Ponto centro() {
		return centro;
	}
	
	public abstract double area();
	
	public abstract double perimetro();
	
	@Override
	public String toString() {
		return "Figura: ";
	}
}
