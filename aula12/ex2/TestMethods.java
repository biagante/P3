package aula12.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMethods {
	
	public static void main(String[] args) {
		List<Figura> list = new ArrayList<>();
		list.add(new Quadrado(1));
		list.add(new Quadrado(2));
		list.add(new Retangulo(2,3));
		System.out.println("Maior figura:\n" + maiorFiguraJ7(list));
		System.out.println("Maior perímetro:\n" + maiorPerimetroJ7(list));
		System.out.println("Soma total das áreas:\n" + areaTotalJ8(list));
		System.out.println("Soma total das áreas dos quadrados:\n" + areaTotalJ8(list,"Quadrado"));
		System.out.println("Soma total das áreas dos retangulos:\n" + areaTotalJ8(list,"Retangulo"));
	}

	private static Figura maiorFiguraJ7(List<Figura> figs) {
		Figura maior = figs.get(0);
		for (Figura f : figs) {
			if (f.compareTo(maior) >= 1)
				maior = f;
		}
		return maior;
	}
	
	private static Figura maiorPerimetroJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura arg0, Figura arg1) {
				double difference = arg0.perimetro() - arg1.perimetro();
				if(difference > 0) return 1;
				else if(difference < 0) return -1;
				else return 0;
			}
		}).get();
	}
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream().mapToDouble(x -> x.area()).sum();
		
	}
	
	private static double areaTotalJ8(List<Figura> figs,String subtipoNome){
		return figs.stream()
				.filter(x -> x.getClass().getSimpleName().equals(subtipoNome))
				.mapToDouble(x -> x.area()).sum();

		
	}
}
