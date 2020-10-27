package aula2;

import java.util.*;

public class aula2_2 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduza o nome do ficheiro: ");
		String filename = sc.nextLine();		
		SoupOfLetters game = new SoupOfLetters(filename);
		game.play();
		game.finalResult();
		sc.close();
		
	}
	
}