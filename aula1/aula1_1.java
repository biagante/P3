package aula1;
import java.util.*;

public class aula1_1 {

	public static void main(String[] args) {
	
		Scanner read = new Scanner(System.in);
		System.out.print("Input: ");
		String input = read.nextLine();
		String[] words = input.split(" ");
		read.close();
		System.out.println("Total de caracteres numéricos: " + contaNum(input));
		if (contaNum(input) == input.length()) {
			System.out.println("Só tem letras minísculas: false ");
			System.out.println("Só tem letras maísculas: false");
		} else {
			System.out.println("Só tem letras minísculas: " + (input.toLowerCase().equals(input)));
			System.out.println("Só tem letras maísculas: " + (input.toUpperCase().equals(input)));
		}
		System.out.print("Total de palavras lidas : " + words.length);
		String newStr = null;
		for(String word : words) {
			newStr = "";
			System.out.printf("\n\"%s\" -> ",word);
			for (int i = 0; i < word.length()-1; i+=2) {
				newStr += String.valueOf(word.charAt(i+1)) + String.valueOf(word.charAt(i));
			}
			if (word.length() % 2 != 0 ) {
				newStr += word.charAt(word.length()-1);
			}
			System.out.printf("%s",newStr);
		}
		
	}
	
	static int contaNum(String str) {
		int num = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				num++;
			}
		}
		return num;
	}

}
