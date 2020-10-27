package aula2;

import aula2.users.*;
import java.util.*;

public class aula2_1{
	
	static VideoClube spot = new VideoClube(2); //N = 2
	//cada utilizador poderá requisitar 2 filmes em simultâneo
	//o nome do videoclube será spot para facilidade de escrita
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		while (true) {
			int opcao = -1;
			System.out.println("-------------------------------");
			System.out.println("          VideoClube            ");
			System.out.println("-------------------------------");
			System.out.println("1 - Introduzir utilizador ");
			System.out.println("2 - Remover utilizador ");
			System.out.println("3 - Listar filmes por utilizador ");
			System.out.println("4 - Histórico de filmes do utilizador ");
			System.out.println("5 - Introduzir filme ");
			System.out.println("6 - Remover filme");
			System.out.println("7 - Verificar a disponibilidade");
			System.out.println("8 - Efetuar empréstimo");
			System.out.println("9 - Efetuar devolução");
			System.out.println("10 - Listar filmes (catálogo)");
			System.out.println("11 - Listar filmes por rating");
			System.out.println("0 - Sair do programa ");
			System.out.println("-------------------------------");
			System.out.print("Opção: ");
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				erro();
			}
			System.out.println("-------------------------------");
			if (opcao == 1) addUser();
			else if(opcao == 2) removeUser();
			else if(opcao == 3) listUserMovies();
			else if(opcao == 4) listUserMovieHistory();
			else if(opcao == 5) addMovie();
			else if(opcao == 6) removeMovie();
			else if(opcao == 7) checkAvailable();
			else if(opcao == 8) emprestMovie();
			else if(opcao == 9) devolveMovie();
			else if(opcao == 10) printCatalog();
			else if(opcao == 11) printCatalogWithRate();
			else if(opcao == 0) break;
			else erro();
			}
		}
	static void addUser() {
		System.out.println("1 - Estudante");
		System.out.println("2 - Funcionário");
		System.out.print("Selecione o seu estatuto: ");
		int type = Integer.parseInt(sc.nextLine());
		System.out.print("Data de inscrição: ");
		String[] insc = sc.nextLine().split("-");
		int d = Integer.parseInt(insc[0]);
		int m = Integer.parseInt(insc[1]);
		int a = Integer.parseInt(insc[2]);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nº cartão de cidadão: ");
		int cc = Integer.parseInt(sc.nextLine());
		System.out.print("Data de nascimento(dd-mm-aaaa): ");
		String[] date = sc.nextLine().split("-");
		int dia = Integer.parseInt(date[0]);
		int mes = Integer.parseInt(date[1]);
		int ano = Integer.parseInt(date[2]);
		if(type == 1) {
			System.out.print("NºMec: ");
			int nmec = Integer.parseInt(sc.nextLine());
			System.out.print("Curso: ");
			String curso = sc.nextLine();
			spot.addUser(new Student(new Data(d,m,a),nome,cc,new Data(dia,mes,ano),nmec,curso));
		} 
		else if(type == 2) {
			System.out.print("Nº de funcionário: ");
			int numEmp = Integer.parseInt(sc.nextLine());
			System.out.print("Nº fiscal: ");
			int numFisc = Integer.parseInt(sc.nextLine());
			spot.addUser(new Employee(new Data(d,m,a),nome,cc,new Data(dia,mes,ano),numEmp,numFisc));
		}
		System.out.println("Utilizador adicionado com sucesso");		
	}
	
	private static void removeUser() {
		System.out.print("Nº do cartão de cidadão: ");
		spot.removeUser(Integer.parseInt(sc.nextLine()));
		System.out.println("Utilizador removido com sucesso");		
	}
	
	private static void listUserMovies() {
		System.out.print("Nº do cartão de cidadão: ");
		spot.printUserMovies(Integer.parseInt(sc.nextLine()));		
	}
	
	private static void listUserMovieHistory() {
		System.out.print("Nº do cartão de cidadão: ");
		spot.printUserMovieHistory(Integer.parseInt(sc.nextLine()));		
	}
	
	private static void addMovie() {
		System.out.print("Título: ");
		String title = sc.nextLine();
		System.out.print("Idade: ");
		String age = sc.nextLine();
		System.out.print("Categoria: ");
		String catg = sc.nextLine();
		spot.addMovie(title, catg, age);
		System.out.println("Filme adicionado com sucesso");		
	}
	
	private static void removeMovie() {
		System.out.print("ID do filme: ");
		spot.removeMovie(Integer.parseInt(sc.nextLine()));
	}
	
	private static void checkAvailable() {	
		System.out.print("ID do filme: ");
		spot.checkIfAvailable(Integer.parseInt(sc.nextLine()));
	}
	
	private static void emprestMovie() {
		System.out.print("ID do filme: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Nº do cartão de cidadão do utilizador: ");
		int cc = Integer.parseInt(sc.nextLine());
		spot.emprestMovie(id, cc);
	}
	
	private static void devolveMovie() {
		System.out.print("ID do filme: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Nº do cartão de cidadão do utilizador: ");
		int cc = Integer.parseInt(sc.nextLine());
		System.out.print("Rating(0-10): ");
		int rate = Integer.parseInt(sc.nextLine());
		if(rate < 0 || rate > 10) {
			erro();
			return;
		}
		spot.devolveMovie(id, cc, rate);		
	}
	
	private static void printCatalog() {
		spot.printCatalog();		
	}
	
	private static void printCatalogWithRate() {
		spot.printCatalogWithRate();
		
	}
	private static void erro() {
		System.out.println("Número inválido");
		System.exit(1);
		
	}
}