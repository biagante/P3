package aula1;

import java.util.Scanner;

public class aula1_3{
	public static void main (String args[]) {
		Scanner rd = new Scanner(System.in);
		System.out.println("----------------------");
		System.out.println(" Figuras geométricas");
		System.out.println("----------------------");
		System.out.println("1 - Criar um círculo");
		System.out.println("2 - Criar um quadrado");
		System.out.println("3 - Criar um rectângulo");
		System.out.println("----------------------");
		System.out.print("\nOpção: ");
		int op = Integer.parseInt(rd.nextLine());
		
		Circulo circle = null;
		Quadrado square = null;
		Retangulo rectangle = null;
		
		if(op == 1) {
			System.out.print("Raio: ");
			int raio = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada x do centro: ");
			int x = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada y do centro: ");
			int y = Integer.parseInt(rd.nextLine());
			circle = new Circulo(x,y,raio);
			System.out.println("\nInfo da figura introduzida: \n" + circle);
		}
		else if(op == 2) {
			System.out.print("Largura: ");
			int largura = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada x do centro: ");
			int x = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada y do centro: ");
			int y = Integer.parseInt(rd.nextLine());
			square = new Quadrado(x,y,largura);
			System.out.println("\nInfo da figura introduzida: \n" + square);
		}
		else if(op == 3) {
			System.out.print("Largura: ");
			int largura = Integer.parseInt(rd.nextLine());
			System.out.print("Altura: ");
			int altura = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada x do centro: ");
			int x = Integer.parseInt(rd.nextLine());
			System.out.print("Coordenada y do centro: ");
			int y = Integer.parseInt(rd.nextLine());
			rectangle = new Retangulo(x,y,largura,altura);
			System.out.println("\nInfo da figura introduzida: \n" + rectangle);
		}
		System.out.println();
		
		//alínea e),verifica se dois círculos são iguais e se se interceptam;
		Circulo circle2 = new Circulo(7,0,3);
		Circulo circle3 = new Circulo(4,3,5);
		
		
		if(circle != null){
			System.out.println("A figura é um círculo de raio 3: "+circle.iguais(circle2));
			System.out.println("Interseta o círculo com centro no ponto "+circle2.centro()+" e de raio "
			+circle2.raio()+": "+circle.intercepta(circle2));
			System.out.println("Interseta o círculo com centro no ponto "
			+circle3.centro()+" e de raio "+circle3.raio()+": "+circle.intercepta(circle3));
		}
	}
}