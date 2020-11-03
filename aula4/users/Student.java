package aula4.users;
import aula4.*;

//Estudantes: caracterizados por um nome, número de CC, data de nascimento,
//número mecanográfico e curso;

public class Student extends User{
	final String curso;
	final int nmec;
	
	public Student(Data insc, String nome, int cc, Data datNasc, int nmec, String curso) {
		super(insc, nome, cc, datNasc); //reusing parent constructor (aka User)
		this.curso = curso;
		this.nmec = nmec;
	}
	
	public String curso() {
		return curso;
	}
	public int nmec() {
		return nmec;
	}
}

