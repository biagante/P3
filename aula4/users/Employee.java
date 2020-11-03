package aula4.users;
import aula4.*;

//Funcionários: caracterizados por um nome, número de CC, data de nascimento,
//número de funcionário e número fiscal.

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
