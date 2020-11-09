package aula5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public Data() {
		String[] date = currentDate().split("-");
		this.dia = Integer.parseInt(date[0]);
		this.mes = Integer.parseInt(date[1]);
		this.ano = Integer.parseInt(date[2]);
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
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", dia,mes,ano);
	}
	
	//If we print the instance of LocalDateTime class, it prints 
	//current date and time.
	//To format the current date, you can use DateTimeFormatter class
	private static String currentDate() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
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