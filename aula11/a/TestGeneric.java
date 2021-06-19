package aula11.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class TestGeneric {
	public static void main(String[] args) {
		
		List<Pessoa> vp = new LinkedList<Pessoa>();
		System.out.println("\nLinkedList - Pessoa\n");
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
	
		printSet(vp.iterator());

		List<Pessoa> lp = new ArrayList<Pessoa>();
		System.out.println("\nArrayList - Pessoa\n");
		while ( vec.hasNext() )
			lp.add(vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		
		List<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		System.out.println("\nLinkedList - Figura\n");
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		System.out.println("\nArrayList - Rectângulos\n");
		// Partindo do principio que Quadrado extends Retangulo:
		List< Retangulo > quadList = new ArrayList<Retangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		printSet(quadList.iterator());
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}
	
	static double sumArea(List<? extends Figura> list) {
		double result = 0;
		@SuppressWarnings("rawtypes")
		Iterator it = list.iterator();
		while(it.hasNext())
			result += ((Figura)it.next()).area();
		return result;
	}
	
	static void printSet(@SuppressWarnings("rawtypes") Iterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}