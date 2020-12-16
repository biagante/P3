package aula10;

public class Circulo extends Figura{
	private double raio;
	
	public Circulo(double x, double y, double r) {
		this(new Ponto(x,y), r);
	}
	
	public Circulo(Ponto c, double r) {
		super(c);
		raio = r;
	}
	
	public Circulo(double r) {
		this(new Ponto(), r);
	}
	
	public Circulo(Circulo circle) {
		this(circle.centro(), circle.raio());
	}
	
	//getters
	public double raio() {
		return raio;
	}
	public double area() {
		return Math.PI * raio * raio;
	}
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	@Override
	public String toString() {
		return "Círculo de Centro " + centro()
				+ " e de raio " + raio();
	}
	
	public boolean equals(Circulo circle) {
		return raio == circle.raio() && centro == circle.centro();
	}
	
	public boolean intercepta(Circulo circle) {
		//calculamos a distancia entre o centro dos dois circulos e a soma do raio dos 2 circulos
		//se a soma dos dois raios for maior ou igual a distancia entre os 2 circulos, interceptam-se
		return centro.distancia(circle.centro()) <= raio + circle.raio();
	}

}