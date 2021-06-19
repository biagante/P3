package aula12.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class wordCounter {
	
	private Map<String, Integer> wordCount;
	public int different;
	public int total;
	
	public wordCounter(String file) throws IOException{
		wordCount = new TreeMap<>();
		readWords(file);
		countWords(file);
	}

	@SuppressWarnings("deprecation")
	public void readWords(String file) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(file));
		lines.stream().flatMap(x -> Arrays.stream(x.split(" "))).forEach(word -> {
			if(wordCount.containsKey(word))
				wordCount.put(word, new Integer(wordCount.get(word)+1));
			else
				wordCount.put(word, new Integer(1));
		});
	}
	
	private void countWords(String file) throws IOException {
		Set<String> differentWordsSet = new HashSet<>();
		List<String> lines = Files.readAllLines(Paths.get(file));
		lines.stream().flatMap(line -> Arrays.stream(line.split(" "))).forEach(word -> {
				differentWordsSet.add(word);
				total++;
		});
		different = differentWordsSet.size();
		
	}
	
	public void writeInfoToFile(String file) {
		PrintWriter pwf = null;
		try {
			pwf = new PrintWriter(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		pwf.println(mapToString());
		pwf.close();
	}
	
	public String mapToString() {
		return wordCount.keySet().stream().map(key -> key+"\t"+wordCount.get(key)).collect(Collectors.joining("\n"));
	}
}
