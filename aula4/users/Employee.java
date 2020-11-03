package aula4.users;
import aula4.*;

//Funcion�rios: caracterizados por um nome, n�mero de CC, data de nascimento,
//n�mero de funcion�rio e n�mero fiscal.

public class Employee extends User {
	final int numFisc;
	final int numEmp;
	
	public Employee(Data insc, String nome, int cc, Data datNasc, int numEmp, int numFisc) {
		super(insc, nome, cc, datNasc); //reusing parent constructor (aka User)
		this.numEmp = numEmp;
		this.numFisc = numFisc;
	}
	
	public int numFisc() {
		return numFisc;
	}
	
	public int numEmp() {
		return numEmp;
	}
}
