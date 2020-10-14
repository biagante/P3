package aula1;

public class Retangulo{
	private double largura;
	private double altura;
	private double area;
	private double perimetro;
	private Ponto centro;
	
	public Retangulo(double x, double y, double larg, double alt) {
		centro = new Ponto(x,y);
		largura = larg;
		altura = alt;
		area = largura * altura;
		perimetro = 2 * largura + 2 * altura; 
	}
	
	public Retangulo(Ponto p, double larg, double alt) {
		centro = p;
		largura = larg;
		altura = alt;
		area = largura * altura;
		perimetro = 2 * largura + 2 * altura;
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
	
	public String toString() {
		return "Tipo: Quadrado \nLargura: " + largura 
				+ "\nAltura: " + altura
				+ "\nCentro: " + centro 
				+ "\nÁrea: " + area
				+ "\nPerímetro: " + perimetro;
	}
	
	
}