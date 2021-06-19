package aula12.ex3;

public class PratoDieta extends Prato implements Comparable<Prato>{

private double maxCaloria;
	
	//Construtor
	public PratoDieta(String nome, double maxCaloria)
	{
		super(nome);
		this.maxCaloria = maxCaloria;
	}
	
	public double maxCaloria() { return maxCaloria; }
	
	@Override public String toString()
	{
		return "Dieta ("+maxCaloria+" Calorias) "+ super.toString();
	}
	public boolean addIngrediente(Alimento a)
	{
		if(super.composicao().contains(a) || a==null || ((a.calorias()+super.maxCalorias()) >= maxCaloria))
			return false;
		else {
			super.addIngrediente(a);
			return true;
		}		
	}
}
