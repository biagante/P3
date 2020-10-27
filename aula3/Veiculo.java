package aula3;

public class Veiculo {
	
	private Condutor driver;
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private int peso;
	private int passageiros;
	
	public Veiculo(Condutor c,int cl,int pt,int lt,int p) {
		driver = c;
		cilindrada = cl;
		potencia = pt;
		lotacao = lt;
		peso = p;
		passageiros = 0;
	}
	
	//getters
	public Condutor condutor() {
		return driver;
	}
	public int cilindrada() {
		return cilindrada;
	}
	public int potencia() {
		return potencia;
	}
	public int lotacao() {
		return lotacao;
	}
	public int peso() {
		return peso;
	}
	public int passageiros() {
		return passageiros;
	}
	
	
	public void addPass() {
		if(lotacao > passageiros) {
			this.passageiros++;
			System.out.printf("\nPassageiro adicionado. Tem %d passageiro(s)", this.passageiros);
		}
		else {
			System.out.println("\nVeículo cheio, impossível adicionar passageiros");
		}
	}
	
	public void removePass() {
		if(passageiros > 0) {
			this.passageiros--;
			System.out.printf("\nPassageiro removido. Tem %d passageiro(s)", this.passageiros);
		}
		else {
			System.out.println("Veículo vazio, impossível remover passageiros");
		}
	}
	
	@Override
	public String toString() {
		return "\nCondutor(a): " + driver.nome() +
			   "\nNúmero de passageiros: " + passageiros() +
			   "\nCilindrada: " + cilindrada() + 
			   "\nPotência: " + potencia()+
			   "\nPeso Bruto: " + peso() + "\n";
	}
}
