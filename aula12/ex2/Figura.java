package aula12.ex2;

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
	
	public int compareTo(Figura shape) {
		return (int)(this.area() - shape.area());
	}
	
	@Override
	public String toString() {
		return "Figura: ";
	}
}
