package aula5;

public class Motorizado extends Veiculo{

	private int cilindrada;
	private int maxSpeed;
	private String matricula;
	private double consumo;
	private double combustivel;
	
	
	public Motorizado(int ano, String cor,int nrodas, int cilindrada,int maxSpeed, String matricula,double consumo, double combustivel) {
		super(ano,cor,nrodas);
		this.maxSpeed = maxSpeed;
		this.matricula = matricula;
		this.cilindrada = cilindrada;		
		this.consumo = consumo;
		this.combustivel = combustivel;
	}
	
	public int maxSpeed() {
		return maxSpeed;
	}
	public String matricula() {
		return matricula;
	}
	public int getPotencia() {
		return cilindrada;
	}
	public double getConsumo() {
		return consumo;
	}
	public double getCombustivel() {
		return combustivel;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nMotorizado -> Cilindrada: %d, Velocidade máxima: %d, Matrícula: %s",cilindrada,maxSpeed,matricula);
	}
}
