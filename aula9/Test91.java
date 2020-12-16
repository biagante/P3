package aula9;

import java.io.*;

public class Test91 {

	public static void main(String[] args) throws IOException{
		//testing with user input
		ScannerAbeirense a = new ScannerAbeirense();
		System.out.println("\nScannerAbeirense com informação do utilizador\n");
		System.out.println("Teste .next()");
		System.out.print("Insira uma palavra: ");
		String n = a.next();
		System.out.println(n);
		
		a.nextLine();
		
		System.out.println("\nTeste .nextLine()");
		System.out.print("Insira uma frase: ");
		String m = a.nextLine();
		System.out.println(m);
		a.close();
		
		//testing with info from file
		System.out.println("\nScannerAbeirense com informação de um ficheiro\n");
		File f = new File("src/aula9/Text91.txt");
		ScannerAbeirense af = new ScannerAbeirense(f);
		while(af.hasNext()) {
			System.out.println(af.next());
		}
		af.close();
		
	}
}
