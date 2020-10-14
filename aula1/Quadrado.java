package aula1;

public class Quadrado{
	private double largura;
	private double area;
	private double perimetro;
	private Ponto centro;
	
	public Quadrado(double x, double y, double larg) {
		centro = new Ponto(x,y);
		largura = larg;
		area = largura * largura;
		perimetro = 4 * largura;
	}
	
	public Quadrado(Ponto p, double larg) {
		centro = p;
		largura = larg;
		area = largura * largura;
		perimetro = 4 * largura;
		
	}
	//getters
	public double largura() {
		return largura;
	}
	public double area() {
		return area;
	}
	public double perimetro() {
		return perimetro;
	}
	public Ponto centro() {
		return centro;
	}
	
	public String toString() {
		return "Tipo: Quadrado \nLargura: " + largura 
				+ "\nCentro: " + centro 
				+ "\nÁrea: "+area
				+ "\nPerímetro: "+perimetro;
	}
}