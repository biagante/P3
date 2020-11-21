package aula7;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class Test71 {
	static LinkedList<Voo> voos = new LinkedList<Voo>();
	static LinkedList<Companhia> companhias = new LinkedList<Companhia>();
	static LinkedList<String> origem = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException{
		String info = getFileInfo();
		System.out.print(info);
		if(saveFileInfo(info))
			System.out.println("\nInformação guardada com sucesso no ficheiro cidades.txt");
		if(writeToFileCities())
			System.out.println("\nInformação guardada com sucesso no ficheiro Infopublico.txt");
		if(saveBinaryInfo(info))
			System.out.println("\nImformação binário guardada com sucesso no ficheiro BinaryInfo.bin");
	}


	public static String getFileInfo() throws IOException{
		List<String> voosInfo = Files.readAllLines(Paths.get("src/aula7/voos.txt"));
		List<String> cInfo = Files.readAllLines(Paths.get("src/aula7/companhias.txt"));
		
		//cria lista de companhias com info do ficheiro
		for(int i = 1; i < cInfo.size(); i++) {
			Companhia c = new Companhia(cInfo.get(i).split("\t")[0],cInfo.get(i).split("\t")[1]);
			companhias.add(c);
		}
		
		//cria lista de voos com info do ficheiro
		for(int i=1;i<voosInfo.size();i++)
		{
			Hora atraso;
			String tag="";
			Companhia corporate = null;
			
			//guarda info do ficheiro
			String[] arrayVoos = voosInfo.get(i).split("\t");
			//processar hora
			Hora h = new Hora(Integer.parseInt(arrayVoos[0].split(":")[0]), Integer.parseInt(arrayVoos[0].split(":")[1]));
			//processar nome do voo e sigla de companhia
			tag = arrayVoos[1].substring(0, 2);			
			for(Companhia c : companhias) {
				if(c.sigla().equals(tag)) {
					corporate = c;
					break;
				}
					
			}
			origem.add(arrayVoos[2]);
			//processar atrasos e lista de voos
			if(arrayVoos.length==4) {
				if(corporate!=null) {
					atraso = new Hora(Integer.parseInt(arrayVoos[3].split(":")[0]), Integer.parseInt(arrayVoos[3].split(":")[1]));
					voos.add(new Voo(h, corporate, arrayVoos[2], atraso, arrayVoos[1]));
				}
			}
			else {
				if(corporate!=null) {
					voos.add(new Voo(h, corporate, arrayVoos[2], arrayVoos[1]));
				}
			}
		}
		String result="Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObs\n";
		for(Voo v : voos) {
			result = result+v.toString()+"\n";
		}
		//Calcule a média dos atrasos por companhia e imprime
		printDelayAverage();
		System.out.println();
		return result;
		
	}
	//Guarde a tabela no ficheiro Infopublico.txt.
	public static boolean saveFileInfo(String info)throws IOException
	{
		Files.write(Paths.get("src/aula7/Infopublico.txt"), info.getBytes());
		return true;
	}
	
	//Calcule a média dos atrasos por companhia
	public static void printDelayAverage()	{
		Hashtable<Companhia, Integer> delays = new Hashtable<>();
		System.out.println("\n\n\nCompanhia\t\tAtraso médio");
		
		LinkedList<Companhia> comps = companhias;
		int sum, count;
		
		for (Companhia companhia : comps)
		{
			sum = 0;
			count = 1;
			for (Voo voo : voos)
			{
				if(voo.companhia().equals(companhia))
				{
					if(voo.atraso() != null) {
						sum += voo.atraso().m();
						count++;
					}
				}
			}
			delays.put(companhia, sum/count);
		}
		
		for (Companhia companhia : comps)
		{

			String format = "%-24s%s%n";
			System.out.printf(format, companhia.toString(), Hora.minsToHoursStr(delays.get(companhia)));
		}
	}

	//total de chegadas de cada cidade origem
	public static String NumberofFlights() {
		String end="";
		HashMap<String,Integer> r = new HashMap<String,Integer>();
		Voo[] cp = voos.toArray(new Voo[0]);
		for (Voo v : cp) {
			if(r.containsKey(v.origem())) {
				r.put(v.origem(), (r.get(v.origem()) + 1));
			}
			else {
				r.put(v.origem(), 1);
			}
		}		
		end+= "Origem	Voo\n";		
		String[] sortedOrigens = r.keySet().toArray(new String[0]);
		Arrays.sort(sortedOrigens, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return r.get(o1)-r.get(o2);
			}
		});
		for(String og : sortedOrigens) {
			end+=(String.format("%-18s\t%s\n", og, r.get(og)));
		}
		return end;
	}
	
	public static boolean writeToFileCities() throws IOException {
		Files.write(Paths.get("src/aula7/cidades.txt"), NumberofFlights().getBytes());
		return true;
	}
	
	//armazenando os dados num ficheiro binário	(Infopublico.bin)
	public static boolean saveBinaryInfo(String info) throws IOException {
		RandomAccessFile binFile = new RandomAccessFile("src/aula7/BinaryInfo.bin", "rw");
		binFile.write(info.getBytes());
		binFile.close();
		return true;
	}
}
