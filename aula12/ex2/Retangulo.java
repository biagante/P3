package aula12.ex2;

public class Retangulo extends Figura{
	private double largura;
	private double altura;
	
	public Retangulo(double x, double y, double larg, double alt) {
		this(new Ponto(x,y), larg, alt);		
	}
	
	public Retangulo(Ponto p, double larg, double alt) {
		super(p);
		largura = larg;
		altura = alt;
	}
	
	public Retangulo(Retangulo r) {
		this(r.centro(),r.largura(),r.altura());
	}
	
	public Retangulo(double larg, double alt) {
		this(new Ponto(),larg,alt);
	}
	
	//getters
	public double largura() {
		return largura;
	}
	public double altura() {
		return altura;
	}
	public Ponto centro() {
		return centro;
	}
	
	public double area() {
		return largura * altura;
	}
	public double perimetro() {
		return 2 * largura + 2 * altura;
	}
	
	
	public String toString() {
		return "Retangulo de Centro " + centro() 
		+ ", altura " + altura() 
		+ ", comprimento " + largura();
	}
	
	public boolean equals(Retangulo r) {
		return largura == r.largura() && altura == r.altura()
				&& centro.equals(r.centro);
	}
}