package aula6;

public class PratoVegetariano extends Prato implements Comparable<Prato>{

	//Construtor
		public PratoVegetariano(String nome)
		{
			super(nome);
		}
		
		@Override public String toString()
		{
			return "Vegetariano "+super.toString();
		}
		public boolean addIngrediente(Alimento a)
		{
			if(super.composicao().contains(a) || a==null || a instanceof AlimentoVegetariano)
				return false;
			else {
				super.addIngrediente(a);
				return true;
			}
		}
}
