package aula3;

public class Test33 {

	public static void main(String[] args) {
		Condutor a1 = new Condutor("Tiago", 19999, new Data(1,12,2000), 'B');
		Condutor a2 = new Condutor("Maria", 43232, new Data(4,9,2000), 'C');
		Condutor a3 = new Condutor("Jorge", 33423, new Data(1,12,1968), 'D');
		Condutor a4 = new Condutor("Ana", 12323, new Data(1,12,1998), 'A');
		Ligeiro l = new Ligeiro(a1,120, 72, 4, 1200);
		Motociclo m = new Motociclo(a2,95, 77, 2, 800);
		PesadoMercadorias p = new PesadoMercadorias(a3,322, 88, 2, 3800);
		PesadoPassageiros a = new PesadoPassageiros(a4,322, 90, 12, 4500);
		
		System.out.print(a.info());
		System.out.print(l.info());
		System.out.print(m.info());
		System.out.print(p.info());
	
		System.out.println("\nTestar que tipo de veiculos cada condutor pode conduzir");
		System.out.println("-------");
		System.out.println("Ligeiro");
		System.out.println(a1.carta() + " -> "+ l.podeConduzir(a1));
		System.out.println(a2.carta() + " -> "+ l.podeConduzir(a2));
		System.out.println(a3.carta() + " -> "+ l.podeConduzir(a3));
		System.out.println(a4.carta() + " -> "+ l.podeConduzir(a4));
		System.out.println("Motociclo");
		System.out.println(a1.carta() + " -> "+ m.podeConduzir(a1));
		System.out.println(a2.carta() + " -> "+ m.podeConduzir(a2));
		System.out.println(a3.carta() + " -> "+ m.podeConduzir(a3));
		System.out.println(a4.carta() + " -> "+ m.podeConduzir(a4));
		System.out.println("Pesado de Mercadoria");
		System.out.println(a1.carta() + " -> "+ p.podeConduzir(a1));
		System.out.println(a2.carta() + " -> "+ p.podeConduzir(a2));
		System.out.println(a3.carta() + " -> "+ p.podeConduzir(a3));
		System.out.println(a4.carta() + " -> "+ p.podeConduzir(a4));	
		System.out.println("Pesado de Passageiros");
		System.out.println(a1.carta() + " -> "+ a.podeConduzir(a1));
		System.out.println(a2.carta() + " -> "+ a.podeConduzir(a2));
		System.out.println(a3.carta() + " -> "+ a.podeConduzir(a3));
		System.out.println(a4.carta() + " -> "+ a.podeConduzir(a4));	
		System.out.println();
		System.out.println("-------");
		System.out.println("Testar entrada e saida de passageiros");
		System.out.println("------");
		l.addPass();
		System.out.print(l.info());
		l.addPass();
		System.out.print(l.info());
		l.addPass();
		System.out.print(l.info());
		l.addPass();
		System.out.print(l.info());
		l.addPass();
		System.out.print(l.info());
		l.removePass();
		System.out.print(l.info());
		a.addPass();
		System.out.print(a.info());
		a.removePass();
		System.out.print(a.info());
		
	}
	
}
