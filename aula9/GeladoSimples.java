package aula9;

public class GeladoSimples implements Gelado {
	
	String flavor;
	
	public GeladoSimples(String sabor) {
		flavor = sabor;
	}
	
	@Override
	public void base(int i) {
		if (i == 1) {
			System.out.print("\n"+ i + " bola de gelado de " + flavor);
		}
		else {
			System.out.print("\n" + i + " bolas de gelado de " + flavor);
		}
	}

}
