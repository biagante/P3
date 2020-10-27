package aula3;
import java.util.*;

public class MovieList {
	
	private List<Movie> movies = new ArrayList<>();
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void removeMovie(Movie movie) {
		movies.remove(movie);
	}
	
	public Movie getMovie(int id) {
		for(Movie movie : moviesToArray()) {
			if(movie.ID() == id) {
				return movie;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public int size() {
		return movies.size();
	}
	
	public Movie[] moviesToArray() {
		return movies.toArray(new Movie[0]);
	}
	
}
