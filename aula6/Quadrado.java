package aula6;

public class Quadrado extends Figura{
	private double largura;
	
	public Quadrado(double x, double y, double larg) {
		this(new Ponto(x,y), larg);
	}
	public Quadrado(Ponto p, double larg) {
		super(p);
		largura = larg;
	}
	public Quadrado(double larg) {
		this(new Ponto(), larg);
	}
	public Quadrado(Quadrado q) {
		this(q.centro(),q.largura());
	}
	
	//getters
	public double largura() {
		return largura;
	}
	public double area() {
		return largura * largura;
	}
	public double perimetro() {
		return 4 * largura;
	}
	public Ponto centro() {
		return centro;
	}
	
	public String toString() {
		return "Quadrado de Centro " + centro()
				+ " e de lado " + largura() ;
	}
	
	public boolean equals(Quadrado q) {
		return largura == q.largura() && centro.equals(q.centro);
	}
}