package aula9;

import java.util.Iterator;

public abstract class TesteIterador {
	public static void main(String[] args) {
		VectorPessoas vp = new VectorPessoas();
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebé na Lista "+i,	2000+i, Data.today()));
		
		System.out.println("ITERATOR - VectorPessoas");
		Iterator<Pessoa> vec = vp.iterator();
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		System.out.println("\nITERATOR - ListaPessoas");
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		System.out.println("\nBFITERATOR - VectorPessoas");
		BFIterator vbfi = vp.bfiterator();
		while(vbfi.hasNext()) {
			System.out.println("-> Previous: " + vbfi.previous());
			System.out.println(vbfi.next());
			System.out.println("BFIterator hasPrevious? "+ vbfi.hasPrevious());
		}
		
		System.out.println("BFITERATOR - ListaPessoas");
		BFIterator lbfi = lp.bfiterator();
		while(lbfi.hasNext()) {
			System.out.println("-> Previous: " + lbfi.previous());
			System.out.println(lbfi.next());
			System.out.println("BFIterator hasPrevious? "+ lbfi.hasPrevious());
		}
	}	
}