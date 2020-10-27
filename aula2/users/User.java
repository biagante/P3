package aula2.users;

import java.util.*;
import aula2.*;

//Os clientes deste videoclube ter�o um n�mero de s�cio sequencial,
//data de inscri��o de s�cio, nome, cc , data de nascimento

public class User {
	static int numCli = 1;
	final int nSocio;
	final Data insc;
	final String nome;
	final int cc;
	final Data datNasc;
	List<Movie> watchedMovies;
	List<Movie> movieHistory; 
	
	public User(Data data, String nome, int cc, Data data2) {
		this.nSocio = numCli++;
		this.insc = data;
		this.nome = nome;
		this.cc = cc;
		this.datNasc = data2;
		watchedMovies = new ArrayList<>();
		movieHistory = new ArrayList<>();
	}
	
	public void emprestMovie(Movie movie) {
		watchedMovies.add(movie);
		movieHistory.add(movie);
	}
	public void devolveMovie(Movie movie) {
		watchedMovies.remove(movie);
	}
	public int numberOfMovies() {
		return watchedMovies.size();
	}
	public Data datNasc() {
		return datNasc;
	}
	public String nome() {
		return nome;
	}
	public int cc() {
		return cc;
	}
	public String toString() {
		return nSocio + (" | ") + nome + (" | ") + cc + (" | ") + datNasc;
	}
	public Movie[] watchedMoviesToArray() {
		return watchedMovies.toArray(new Movie[0]);
	}
	public Movie[] movieHistoryToArray() {
		return movieHistory.toArray(new Movie[0]);
	}
	
}
