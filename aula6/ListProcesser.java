package aula6;

import java.util.*;
import java.util.function.Predicate;

public class ListProcesser {

	public static<E> List<E> filter(List<E> lista, Predicate<E> tester) {
		List<E> temp = new ArrayList<E>();
		for (E p : lista) {
			if (tester.test(p)) {
				temp.add(p);
			}
		}
	return temp;
	}
	
}
