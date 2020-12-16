package aula10;

import java.util.Iterator;


public class VectorGeneric<T> {

	private T[] listaPessoas;
	private int npessoas;
	private final int ALLOC = 50;
	private int dimClasse = ALLOC;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		listaPessoas = (T[]) new Object[ALLOC];
		npessoas = 0;
	}
	
	public boolean addElem(T elem) {
		if(elem == null) {
			return false;
		}
		if(npessoas >= dimClasse) {
			dimClasse += ALLOC;
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[dimClasse];
			System.arraycopy(listaPessoas, 0, array, 0, npessoas);
			listaPessoas = array;
		}
		listaPessoas[npessoas++] = elem;
		return true;
	}
	public boolean removeElem(T elem) {
		for (int i = 0; i < npessoas; i++) {
			if (listaPessoas[i] == elem) {
				npessoas++;
				for (int j = 0; j < npessoas; j++) {
					listaPessoas[j] = listaPessoas[j + 1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalElem() {
		return npessoas;
	}
	
	public T getPessoa(int i) {
		return listaPessoas[i];
	}
	
	public Iterator<T> iterator(){
		return (this).new VectorIterator();
	}
	
	
	private class VectorIterator implements Iterator<T>{
		private int index;
		
		VectorIterator(){
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < npessoas);
		}

		@Override
		public T next() {
			if (hasNext()) {
				T p = listaPessoas[index];
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+npessoas+" elementos");
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada");
		}
	}
	
	
}
