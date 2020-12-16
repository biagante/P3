package aula10;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaGeneric<T> {

	protected LinkedList<T> lista;
	
	public ListaGeneric(LinkedList<T> lista) {
		this.lista = lista;
	}
	public ListaGeneric() {
		lista = new LinkedList<T>();
	}
	
	public void addElem(T elem) {
		lista.add(elem);
	}
	public void removeElem(T elem) {
		lista.remove(elem);
	}
	public int size() {
		return lista.size();
	}
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public Iterator<T> iterator() {
		return (this).new VectorIterator();
	}
	
	private class VectorIterator implements Iterator<T>{
		private int index;
		
		VectorIterator(){
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < lista.size());
		}

		@Override
		public T next() {
			if (hasNext()) {
				T p = lista.get(index);
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+lista.size()+" elementos");
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada");
		}
	}

}
