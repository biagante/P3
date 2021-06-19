package aula12.a;

import java.io.IOException;

public class TestStream {
	
	public static void main(String[] args) throws IOException{
		wordCounter wc = new wordCounter("./src/aula12/a/Policarpo.txt");
		System.out.println("Número total de palavras: " + wc.total);
		System.out.println("Número de palavras diferentes: " + wc.different);
		System.out.println(wc.mapToString());
	}

}
