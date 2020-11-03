package aula4;

//Um filme é caracterizado por um ID sequencial, um título, uma categoria (Ação,
//Comédia, Infantil, Drama, etc.) e uma idade (ALL, M6, M12, M16, M18).

public class Movie {
	static int numFilmes = 1; // iniciado a 0 por não existirem filmes registados
	private int ID;
	private String title;
	private String catg;
	private String age;
	private boolean available; //será usado para empréstimo
	private double ratingAvg;
	private int ratingTotal;
	private int numCli;
	
	public Movie(String title, String cat, String age) {
		this.ID = numFilmes++; //cada filme incrementa o ID sequencialmente
		this.title = title;
		this.catg = cat;
		this.age = age;
		this.available = true;
		this.ratingTotal = 0;
		this.ratingAvg = 0.0;
		this.numCli = 0;
	}
	
	//getters
	public int ID() {
		return ID;
	}
	public String title() {
		return title;
	}
	public String catg() {
		return catg;
	}
	public String age() {
		return age;
	}
	public double rating() {
		return ratingAvg;
	}
	public boolean isAvailable() {
		return available;
	}
	
	public String toString() {
		return ID + " | "
			 +  title + " | "
			 + ratingTotal + " | "
			 + ratingAvg + " | "
			 + catg + " | "
			 + age;
	}
	
	public void emprestMovie() {
		available = false;
		numCli++;
	}
	
	public void devolveMovie(int rating) {
		available = true;
		addRating(rating);
	}
	
	private void addRating(int rating) {
		ratingTotal += rating;
		ratingAvg = (double) ratingTotal / numCli;
	}
	
	public int compareTo(Movie m) {
		if(this.rating() == m.rating()) {
			return 0;
		}
		else if(this.rating() < m.rating()) {
			return -1;
		}
		else {
			return 1;
		}
	}

}
