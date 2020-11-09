package aula5;

import java.util.*;
import java.io.*;

public class Agenda {

	private ArrayList<Pessoa> agenda = new ArrayList<>(); 
	
	public void AgendafromFile(String filename) throws IOException{
		Scanner sc = new Scanner(new File(filename));
		String line = sc.nextLine();
		sc.close();
		FileType a = null;
		if(line.equals("CSV")) {
			a = new CSV();
		}
		else if (line.equals("vCard")) {
			a = new vCard();
		}
		else if (line.equals("Nokia")) {
			a = new Nokia();
		}
		addContacto(a.InfoFromFile(filename));
	}
	
	public void AgendaToFile(String filename, FileType f) throws IOException{
		f.InfoToFile(filename, agenda.toArray(new Pessoa[0]));
	}
	
	public void addContacto(Pessoa[] array) {
		for(Pessoa p : array) {
			agenda.add(p);
		}
	}
	
	public void removeContacto(Pessoa p) {
		if (agenda.contains(p)) {
			agenda.remove(p);
		}
		else {
			System.out.println("Contacto inválido. Não removido.");
		}
	}
	
	public int size() {
		return agenda.size();
	}
	
	@Override
	public String toString() {
		return agenda.toString();
	}
	
}
