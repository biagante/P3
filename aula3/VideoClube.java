package aula3;
import aula3.users.*;

public class VideoClube {
	
	private UserList users = new UserList();
	private MovieList movies = new MovieList();
	
	//Assim, cada utilizador só poderá requisitar simultaneamente um máximo de N
	//vídeos. O valor de N será definido aquando da inicialização do videoclube.
	private int movieLimit; 
	public VideoClube(int n) {
		movieLimit = n;
	}
	
	public void addUser(User student) {
		users.addUser(student);
	}
	
	public void removeUser(int cc) {
		users.removeUser(users.getUser(cc));
	}
	
	public void printUserMovies(int cc) {
		User user = users.getUser(cc);
		System.out.println("-----------------------");
		System.out.println("  Filmes de: " + user.nome());
		System.out.println("-----------------------");
		for(Movie movie : user.watchedMoviesToArray()) {
			System.out.println(movie);
		}
	}
	
	public void addMovie(String title, String catg, String age) {
		movies.addMovie(new Movie(title,catg,age));
	}
	
	public void removeMovie(int id) {
		movies.removeMovie(movies.getMovie(id));
	}
	
	public void checkIfAvailable(int id) {
		String state = "disponível";
		if(!(movies.getMovie(id).isAvailable())) {
			state = "indisponível";
		}
		System.out.println("O filme " + id + " encontra-se " + state);
	}
	
	public void emprestMovie(int id, int cc) {
		Movie movie = movies.getMovie(id);
		User user = users.getUser(cc);
		if(user.numberOfMovies() >= movieLimit) {
			System.out.println("O utilizador "+user.nome() + " atingiu o limite de filmes.");
			return;
		}
		if(!(movie.isAvailable())) {
			System.out.println("O filme "+ id +" está indisponível "
					+ "\n e de momento não pode ser requesitado");
			return;
		}
		movie.emprestMovie();
		user.emprestMovie(movie);
		System.out.println("Filme requisitado com sucesso");
	}
	
	public void devolveMovie(int id, int cc, int rate) {
		Movie movie = movies.getMovie(id);
		User user = users.getUser(cc);
		if(movie.isAvailable()) {
			System.out.println("O filme "+ id + "está disponível. Impossível ter 2 filmes idênticos");
			return;
		}
		movie.devolveMovie(rate);
		user.devolveMovie(movie);
		System.out.println("Filme devolvido com sucesso");
	}
	//listagem do histórico de vídeos emprestados a
	//determinado cliente.
	public void printUserMovieHistory(int cc) {
		User user = users.getUser(cc);
		System.out.println("-----------------------");
		System.out.println("Histórico de filmes de " + user.nome());
		System.out.println("-----------------------");
		for(Movie movie : user.movieHistoryToArray()) {
			System.out.println(movie);
		}
	}
	public void printCatalog() {
		System.out.println("-----------------------");
		System.out.println("  Catálogo de filmes");
		System.out.println("-----------------------");
		for(Movie movie : movies.moviesToArray()) {
			System.out.println(movie);
		}
	}
	public void printCatalogWithRate() {
		Movie[] sortedArray = movies.moviesToArray().clone();
		boolean swap = true;
		Movie temp;
		do {
			swap = false;
			for (int j = 0; j < sortedArray.length - 1; j++) {
				if(sortedArray[j].compareTo(sortedArray[j+1]) < 0) {
					temp = sortedArray[j];
					sortedArray[j] = sortedArray[j + 1];
					sortedArray[j + 1] = temp;
					swap = false;
				}
			}
		} while(swap);
		System.out.println("-----------------------");
		System.out.println("  Catálogo de filmes por rating");
		System.out.println("-----------------------");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i].toString());
		}
	}
}
