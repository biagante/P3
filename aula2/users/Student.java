package aula2.users;
import aula2.*;

//Estudantes: caracterizados por um nome, número de CC, data de nascimento,
//número mecanográfico e curso;

public class Student extends User{
	final String curso;
	final int nmec;
	
	public Student(Data data, String nome, int cc, Data data2, int nmec, String curso) {
		super(data, nome, cc, data2); //reusing parent constructor (aka User)
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

