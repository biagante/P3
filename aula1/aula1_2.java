package aula1;

import java.util.*;

public class aula1_2{
	
	static List<Pessoa> people = new ArrayList<>();

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int opcao = -1;
			System.out.println("-------------------------------");
			System.out.println("              Menu            ");
			System.out.println("-------------------------------");
			System.out.println("1 - Introduzir pessoas ");
			System.out.println("2 - Apagar pessoa ");
			System.out.println("3 - Apresentar lista ");
			System.out.println("4 - Ordenar lista por nome ");
			System.out.println("5 - Ordenar lista por CC ");
			System.out.println("0 - Sair do programa ");
			System.out.println("-------------------------------");
			System.out.print("Opção: ");
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				erro();
			}
			System.out.println("-------------------------------");
			if (opcao == 1) addPessoa();
			else if(opcao == 2) removePessoa();
			else if(opcao == 3) printLista();
			else if(opcao == 4) sortNome();
			else if(opcao == 5) sortCC();
			else if(opcao == 0) break;
			else erro();
			}
		}

	private static void sortCC() {
		List<Pessoa> temp = new ArrayList<>();
		for(int cc : ccToArray()) {
			for(Pessoa indv : pessoaToArray()) {
				if(indv.cc() == cc) {
					temp.add(indv);
					break;
				}
			}
		}
		people = temp;
		System.out.println("Lista ordenada pelo cc");
	}

	static int[] ccToArray() {
		int index = 0;
		int[] ccArr = new int[people.size()];
		for(Pessoa indv : pessoaToArray()) {
			ccArr[index++] = indv.cc();
		}
		Arrays.sort(ccArr);
		return ccArr;
	}

	private static void sortNome() {
		List<Pessoa> temp = new ArrayList<>();
		for(String name: nomesToArray()) {
			for(Pessoa indv : pessoaToArray()) {
				if(indv.nome().equals(name)) {
					temp.add(indv);
					break;
				}
			}
		}
		people = temp;
		System.out.println("Lista ordenada pelo nome");
	}

	static String[] nomesToArray() {
		int index = 0;
		String[] nomesArr = new String[people.size()];
		for(Pessoa indv : pessoaToArray()) {
			nomesArr[index++] = indv.nome();
		}
		Arrays.sort(nomesArr);
		return nomesArr;
	}

	private static void printLista() {
		Pessoa[] arr = pessoaToArray();
		System.out.println("   Nome  |   CC   | Data Nasc. ");
		System.out.println("-------------------------------");
		for (Pessoa indv : arr) {
			System.out.println("| " + indv + " |");
		}
		System.out.println("-------------------------------");
	}

	static Pessoa[] pessoaToArray() {
		return people.toArray(new Pessoa[0]);
	}

	private static void removePessoa() {
		if(people.size() == 0) {
			System.out.println("Lista vazia, operação impossível");
			return;
		}
		Scanner kb = new Scanner(System.in);
		System.out.print("Nome da pessoa a remover: ");
		String input = kb.nextLine();
		List<Pessoa> temp = new ArrayList<>();
		for (Pessoa indv : pessoaToArray()) {
			if(!indv.nome().equals(input)) {
				temp.add(indv);
			}
		}
		if(people.size() == temp.size()) {
			System.out.println("Nome introduzido não encontrado");
		}
		else {
			System.out.println("Pessoa removida");
			people = temp;
		}
	}

	private static void addPessoa() {
		try {
			//get info from user
			Scanner kb = new Scanner(System.in);
			System.out.print("Nome: ");
			String name = kb.nextLine();
			System.out.print("Nº de cartão de cidadão: ");
			int cc = Integer.parseInt(kb.nextLine());
			System.out.print("Data de nascimento(dd-mm-aaaa): ");
			String inpD = kb.nextLine();
			
			//treat data
			String[] data = inpD.split("-");
			if(data.length != 3) throw new IllegalArgumentException();
			Data date = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			people.add(new Pessoa(name, cc, date));
		} catch (Exception e) {
			System.out.println("Input inválido");
			return;
		}
		System.out.println("Pessoa adicionada");
	}

	private static void erro() {
		System.out.println("Número inválido");
		System.exit(1);
		
	}
	
}

