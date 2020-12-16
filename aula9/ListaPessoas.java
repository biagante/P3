package aula9;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaPessoas {

	protected LinkedList<Pessoa> lista;
	
	public ListaPessoas(LinkedList<Pessoa> lista) {
		this.lista = lista;
	}
	public ListaPessoas() {
		lista = new LinkedList<Pessoa>();
	}
	
	public void addPessoa(Pessoa p) {
		lista.add(p);
	}
	public void removePessoa(Pessoa p) {
		lista.remove(p);
	}
	public int size() {
		return lista.size();
	}
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	Iterator<Pessoa> iterator() {
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
			return (index < lista.size());
		}

		@Override
		public Pessoa next() {
			if (hasNext()) {
				Pessoa p = lista.get(index);
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+lista.size()+" elementos");
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
			return (index < lista.size());
		}

		@Override
		public Pessoa next() {
			if (hasNext()) {
				Pessoa p = lista.get(index);
				index++;
				return p;
			}
			throw new IndexOutOfBoundsException("apenas "+lista.size()+" elementos");
		}
		
		@Override
		public boolean hasPrevious() {
			return (index > 0);
		}
		@Override
		public Object previous() {
			if(hasPrevious()) {
				int n = index - 1;
				return lista.get(n);
			}
			return null;
		}
	}
}
