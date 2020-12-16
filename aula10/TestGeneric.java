package aula10;

import java.util.Iterator;

public abstract class TestGeneric {
	public static void main(String[] args) {
		
		VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
		System.out.println("\nVECTORGENERIC - Pessoa\n");
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
	
		printSet(vp.iterator());

		ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
		while ( vec.hasNext() )
			lp.addElem( vec.next() );
		
		System.out.println("\nLISTAGENERIC - Pessoa\n");
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		
		ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));
		figList.addElem(new Retangulo(1,2, 2,5));
		System.out.println("\nLISTAGENERIC - Figura\n");
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		System.out.println("\nLISTAGENERIC - Rectângulos\n");
		// Partindo do principio que Quadrado extends Retangulo:
		ListaGeneric< Retangulo > quadList = new ListaGeneric<Retangulo>();
		quadList.addElem(new Quadrado(3,4, 2));
		quadList.addElem(new Retangulo(1,2, 2,5));
		printSet(quadList.iterator());
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}
	
	static double sumArea(ListaGeneric<? extends Figura> list) {
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