package aula5;

public class Test52 {

	public static void main(String[] args) {
				//Tipos
				Tipo inem = Tipo.INEM;
				Tipo bombeiro = Tipo.Bombeiros;
				Tipo pj = Tipo.PJ;
				Tipo psp = Tipo.PSP;
				Tipo gnr = Tipo.GNR;
				
				//Automóvel
				System.out.println("AUTOMÓVEIS");
				Automovel a1 = new Automovel(2012, "azul", 4, 55, 327, "ET-45-21", 2000.55, 75.75, 5, false);
				Automovel a2 = new Automovel(2013, "amarelo", 4, 60, 330, "15-AU-98", 2004.24, 90.50, 7, true);
				System.out.println(a1);
				System.out.println(a2+"\n");
				
				//AutomoóvelPolicia
				System.out.println("AUTOMÓVEIS DA POLICIA");
				AutomovelPolicia ap1 = new AutomovelPolicia(2000, "vermelho", 4, 53, 127, "AF-15-31", 2120.55, 71.74, 2, false, pj, "120");
				AutomovelPolicia ap2 = new AutomovelPolicia(2010, "verde", 4, 45, 227, "TR-32-11", 1000.55, 73.71, 5, false, gnr, "99");
				System.out.println(ap1);
				System.out.println(ap2+"\n");
				
				//Bicicleta
				System.out.println("BICICLETAS");
				Bicicleta b1 = new Bicicleta(1999, "preto", 2, 275,"SHIMANO");
				Bicicleta b2 = new Bicicleta(2005, "branco", 2, 234, "SPORTFUL");
				System.out.println(b1);
				System.out.println(b2+"\n");
				
				//BicicletaPolicia
				System.out.println("BICICLETAS DA POLICIA");
				BicicletaPolicia bp1 = new BicicletaPolicia(2012, "azul", 2, 548,"MAVIC", bombeiro, "362");
				BicicletaPolicia bp2 = new BicicletaPolicia(2000, "verde", 2, 275,"GORE WEAR", psp, "4");
				System.out.println(bp1);
				System.out.println(bp2+"\n");
				
				//Motociclo
				System.out.println("MOTOCICLOS");
				Motociclo m1 = new Motociclo(1995, "azul", 2, 66, 213, "BB-56-28", 4561.25, 54.23, true);
				Motociclo m2 = new Motociclo(2020, "amarelo", 2, 12, 432, "59-BS-84", 4134.15, 43.23, false);
				System.out.println(m1);
				System.out.println(m2+"\n");
				
				
				System.out.println("MOTOCICLOS DA POLICIA");
				MotocicloPolicia mp1 = new MotocicloPolicia(1999, "azul", 2, 70, 123, "PB-16-38", 4132.25, 12.23, true, inem, "4");
				MotocicloPolicia mp2 = new MotocicloPolicia(2000, "vermelho", 2, 24, 122, "13-AG-14", 1234.85, 45.3, false, pj, "5");
				System.out.println(mp1);
				System.out.println(mp2+"\n");
				
				System.out.println("VEÍCULOS ORDENADOS POR ANO");
				Veiculo[] lista = new Veiculo[4];
				lista[0] = a1;
				lista[1] = m1;
				lista[2] = mp1;
				lista[3] = m2;
				UtilCompare.sortArray(lista);
				for (Veiculo v : lista) {
					System.out.println(v);
				}

	}
}
