package aula7;

public class Hora {

	private int h;
	private int m;
	
	public Hora(int h, int m) {
		if(!validHora(h,m)) {
			throw new IllegalArgumentException();
		}
		this.h = h;
		this.m = m;
	}
	
	public Hora(int minutos) {
		int h = minutos/60;
		int m = minutos%60;
		new Hora(h,m);
	}

	public int h() {
		return h;
	}
	public int m() {
		return m;
	}
	
	public int toMinutes() {
		return h * 60 + m;
	}
	
	public static String minsToHoursStr(int minutes)
	{
		int mins = minutes % 60;
		int hours = minutes / 60;
		return String.format("%02d:%02d", hours,mins);
	}
	
	public boolean validHora(int h, int m) {
		if(h < 00 || h > 23) {
			if(m < 00 || m > 59) {
				return false;
			}
			return false;
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", h,m);
	}
}
