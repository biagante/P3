package aula5;

public abstract class Figura implements Comparable<Figura>{

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
	
	public int compareTo(Figura shape) {
		
		if ((int)(this.area() - shape.area()) > 0) {
			return 1;
		}
		else if((int)(this.area() - shape.area()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
