package aula9;

public class Cone extends GeladoDecorator{

	public Cone(Gelado i){
		super(i);
	}
	
	@Override
	public void base(int i) {
		ice.base(i);
		System.out.print(" em cone");
	}
}
