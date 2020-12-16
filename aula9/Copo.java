package aula9;

public class Copo extends GeladoDecorator{

	public Copo(Gelado i){
		super(i);
	}
	
	@Override
	public void base(int i) {
		ice.base(i);
		System.out.print(" em copo");
	}
}
