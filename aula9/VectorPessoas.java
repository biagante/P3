package aula9;

import java.util.Iterator;

public class VectorPessoas {

	private Pessoa[] listaPessoas;
	private int npessoas;
	private final int ALLOC = 50;
	private int dimClasse = ALLOC;
	
	public VectorPessoas() {
		listaPessoas = new Pessoa[ALLOC];
		npessoas = 0;
	}
	
	public boolean addPessoa(Pessoa p) {
		if(p == null) {
			return false;
		}
		if(npessoas >= dimClasse) {
			dimClasse += ALLOC;
			Pessoa[] array = new Pessoa[dimClasse];
			System.arraycopy(listaPessoas, 0, array, 0, npessoas);
			listaPessoas = array;
		}
		listaPessoas[npessoas++] = p;
		return true;
	}
	public boolean removePessoa(Pessoa p) {
		for (int i = 0; i < npessoas; i++) {
			if (listaPessoas[i] == p) {
				npessoas++;
				for (int j = 0; j < npessoas; j++) {
					listaPessoas[j] = listaPessoas[j + 1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalPessoas() {
		return npessoas;
	}
	
	public Pessoa getPessoa(int i) {
		return listaPessoas[i];
	}
	Iterator<Pessoa> iterator(){
		return (this).new VectorIterator();
	}
	
	BFIterator bfiterator() {
		return (this).new VectorBFIterator();
	}
	
	
	private class VectorIterator implements Iterator<Pessoa>{
		private int index;
		
		VectorIterator(){
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < npessoas);
		}

		@Override
		public Pessoa next() {
			if (hasNext()) {
				Pessoa p = listaPessoas[index];
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+npessoas+" elementos");
		}
		
		public void remove() {
			throw new UnsupportedOperationException("operação não suportada");
		}
	}
	
	private class VectorBFIterator implements BFIterator{
		private int index;
		
		VectorBFIterator(){
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return (index < npessoas);
		}

		@Override
		public Pessoa next() {
			if (hasNext()) {
				Pessoa p = listaPessoas[index];
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+npessoas+" elementos");
		}
		
		@Override
		public boolean hasPrevious() {
			return (index > 0);
		}
		@Override
		public Object previous() {
			if(hasPrevious()) {
				int n = index - 1;
				return listaPessoas[n];
			}
			return null;
		}
	}
}
