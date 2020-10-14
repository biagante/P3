package aula1;

public class Data{
	private int dia;
	private int mes;
	private int ano;
	private static int monthlyDays[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	//validacao das datas -> robustez
	public Data(int d, int m, int a) {
		if (!valida(a,m,d))  throw new IllegalArgumentException();
		dia = d;
		mes = m;
		ano = a;
	}
	
	public int dia() {
		return dia;
	}
	public int mes() {
		return mes;
	}
	public int ano() {
		return ano;
	}
	public String toString() {
		return String.format("%02d-%02d-%04d", dia,mes,ano);
	}
	
	//funcao para verificar se data é válida
	private boolean valida(int ano, int mes, int dia) {
		if(mes < 0 || mes > 12) {
			return false;					
		}
		else if(bissexto() && monthlyDays[mes - 1] < dia || dia < 0) {
			return false;
		}
		else if(!bissexto() && mes != 2 && monthlyDays[mes - 1] < dia || dia < 0 || monthlyDays[1] - 1 < dia) {
			return false;
		}
		else {
			return true;
		}
		
	}

	private boolean bissexto() {
		return ((ano % 4 == 0 && ano % 100 == 0) || ano % 400 == 0);
	}
}