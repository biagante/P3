package aula6;

public class Ponto {
	private double x;
	private double y;
	
	//construtor
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Ponto() { //ponto sem argumentos == origem
		this.x = 0;
		this.y = 0;
	}
	
	//getters
	public double x() {
		return x;
	}
	public double y() {
		return y;
	}
	
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
	
	//calcula a distancia entre 2 pontos d=sqrt((x2−x1)^2+(y2−y1)^2)
	public double distancia(Ponto point) {
		return Math.sqrt(Math.pow(point.x() - x, 2) + Math.pow(point.y() - y, 2));
	}
	
	public boolean equals(Ponto p) {
		return x == p.x() && y == p.y();
	}
	
}
