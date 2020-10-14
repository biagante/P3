package aula1;

public class Circulo{
	private double raio;
	private double area;
	private double perimetro;
	private Ponto centro;
	
	public Circulo(double x, double y, double r) {
		centro = new Ponto(x,y);
		raio = r;
		area = Math.PI * raio * raio;
		perimetro = 2 * Math.PI * raio;
	}
	
	public Circulo(Ponto c, double r) {
		centro = c;
		raio = r;
		area = Math.PI * raio * raio;
		perimetro = 2 * Math.PI * raio;
	}
	
	//getters
	public double raio() {
		return raio;
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
		return "Tipo: Círculo \nCentro: " + centro 
				+"\nRaio: " + raio
				+ "\nÁrea: " + area
				+ "\nPerímetro: " + perimetro;
	}
	
	public boolean iguais(Circulo circle) {
		return raio == circle.raio();
	}
	
	public boolean intercepta(Circulo circle) {
		//calculamos a distancia entre o centro dos dois circulos e a soma do raio dos 2 circulos
		//se a soma dos dois raios for maior ou igual a distancia entre os 2 circulos, interceptam-se
		return centro.distancia(circle.centro()) <= raio + circle.raio();
	}
}