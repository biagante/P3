package aula4;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private String nome;
	private String tcurso;
	private int ects;
	private Professor regente;
	private List<Estudante> alunos;
	
	public Disciplina(String nome, String tcurso, int ects, Professor regente) {
		this.nome = nome;
		this.tcurso = tcurso;
		this.ects = ects;
		this.regente = regente;
		this.alunos = new ArrayList<>();
	}
	
	// Adiciona um aluno à Disciplina
	public boolean addAluno(Estudante est) { 
		if (alunos.contains(est)) {
			return false;
		}
		return alunos.add(est);
	}
	
	// Remove um aluno da Disciplina
	public boolean delAluno(int nMec) { 
		for(Estudante e: getAlunos()) {
			if (e.nMec() == nMec) {
				return alunos.remove(e);
			}
		}
		return false;
	}
	
	// Verifica se aluno está inscrito à disciplina
	public boolean alunoInscrito(int nMec) { 
		for(Estudante e : getAlunos()) {
			if(e.nMec() == nMec) {
				return true;
			}
		}
		return false;
	}
	
	// Retorna o Nº de Alunos Inscritos
	public int numAlunos() { 
		return alunos.size();
	}
	
	@Override
	// Retorna as características da Disciplina
	public String toString() { 
		return "Disciplina: " + nome + " ( " + ects + " ECTS) da Área de " 
			    + tcurso + "\nResponsável: " + regente 
				+ "Existem " + numAlunos() + " alunos inscritos";
	}
	
	// Retorna uma lista com todos os alunos da disciplina
	public Estudante[] getAlunos() {
		return alunos.toArray(new Estudante[0]);
	}
	
	// Retorna uma lista com todos os alunos da disciplina do subtipo “tipo”
	public Estudante[] getAlunos(String tipo) { 
		List<Estudante> tmp = new ArrayList<>();
		for(Estudante e: getAlunos()) {
			if(e.getClass().toString().contains(tipo)) {
				tmp.add(e);
			}
		}
		return tmp.toArray(new Estudante[0]);
	}
	
}
