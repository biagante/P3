package aula9;

public class Topping extends GeladoDecorator {
	
	private String top;
	
	public Topping(Gelado ice, String topping) {
		super(ice);
		top = topping;
	}
	
	public String topping() {
		return top;
	}
	
	@Override
	public void base(int i) {
		ice.base(i);
		System.out.print(" com " + top);
	}

}
