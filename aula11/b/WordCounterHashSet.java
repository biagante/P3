package aula11.b;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordCounterHashSet {

	static LinkedList<String> list = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException{
		Path p = Paths.get("./src/aula11/b/Policarpo.txt");
		List<String> lines = Files.readAllLines(p);
		
		for(String s : lines) {
			countWords(s);
		}
		System.out.println("Número total de palavras: "+ (list.size()-1));
		
		int repeat = 0;
		Set<String> set = new HashSet<String>();
		for(String s : list) {
			if(!set.add(s)) {
				repeat++;
			}
		}
		System.out.println("Número de diferentes palavras: "+((list.size()-1)-repeat));
		System.out.println("Número de palavras repetidas: "+repeat);
		list.clear();
	}

	private static void countWords(String s) {
		String[] array = s.split("\\P{L}+");
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
	}
}
