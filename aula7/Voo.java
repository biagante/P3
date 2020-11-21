package aula7;

public class Voo {
	private String nome; //aka nome do voo
	private Hora hora;
	private Companhia companhia;
	private String origem;
	private Hora atraso;
	private Hora delay;
	
	
	public Voo(Hora hora, Companhia companhia, String origem, String nome)
	{
		this.hora = hora;
		this.origem = origem;
		this.companhia = companhia;
		atraso = null;
		this.nome = nome;
		delay = null;
	}
	public Voo(Hora hora, Companhia companhia, String origem, Hora atraso, String nome)
	{
		this.hora = hora;
		this.origem = origem;
		this.companhia = companhia;
		this.atraso = atraso;
		this.nome = nome;
		delay = addHoras(hora,atraso);
	}
	
	public Hora addHoras(Hora hora, Hora atraso) {
		int h = hora.h()+atraso.h();
		int minuto = 0;
		if(hora.m() + atraso.m() > 60) {
			h++;
			minuto=(hora.m() + atraso.m())%60;
		}
		else {
			minuto=hora.m()+atraso.m();
		}
		if(h >= 24) {
			h = h - 24;
		}
		return new Hora(h,minuto);
	}
	
	
	
	public String nome() {return nome;}
	public Hora hora() {return hora;}
	public Companhia companhia() {return companhia;}
	public String origem() {return origem;}
	public Hora atraso() {return atraso; }
	public Hora delay() {return delay;}
	
	
	@Override
	public String toString() {
		if(atraso!=null)
			return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\tPrevisto: %-5s\t", hora.toString(), nome, companhia.toString(), origem, atraso.toString(),delay.toString());
			
		else
			return String.format("%s\t%-10s\t%-18s\t%-20s\t", hora.toString(), nome, companhia.toString(), origem);
	}
}
