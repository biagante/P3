package aula11.c;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordCounterHashMap {

	static HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException{
		Path p = Paths.get("./src/aula11/b/Policarpo.txt");
		List<String> lines = Files.readAllLines(p);
		
		for(String s : lines) {
			splitWords(s);
		}
		System.out.println("Palavras: \n");
		List<String> keys = new ArrayList<String>(words.keySet());
		//alphabetic order of the words in the file
		Collections.sort(keys);
		for(String s : keys) {
			System.out.println(s + " : " + words.get(s));
		}
	}

	private static void splitWords(String s) {
		String[] array = s.split("\\P{L}+");
		for (int i = 0; i < array.length; i++) {
			if (!words.containsKey(array[i])) {
				words.put(array[i], 1);
			}
			else {
				words.put(array[i], words.get(array[i]) + 1);
			}
		}
	}

	
}
