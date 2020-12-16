package aula9;

public class GeladoDecorator implements Gelado {
	
	protected Gelado ice;
	
	public GeladoDecorator(Gelado i) {
		ice = i;
	}
	
	public void base(int i) {
		ice.base(i);
	}
	
}
