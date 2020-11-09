package aula5;

public class UtilCompare {
	
	@SuppressWarnings("unchecked")
	 public static <T> Comparable <T> findMax(Comparable<T>[] array) {
		 int maxIndex = 0;
		 for (int i = 1; i < array.length; i++) {
			if (array[i] != null && array[i].compareTo((T)array[maxIndex]) > 0) {
				maxIndex = i;
			}
		 }
		 return array[maxIndex];
	 }
	
	@SuppressWarnings("unchecked")
	public static <T> void sortArray(Comparable<T>[] array){
		Comparable<T> aux;
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if(array[i].compareTo((T)array[j]) < 0) {
					aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
		}
	}
}
