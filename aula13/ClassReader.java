package aula13;

import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.Scanner;

import aula12.ex2.Circulo;

public class ClassReader {
	
	public static final Scanner in = new Scanner(System.in);
	static LinkedList<Type> primitiveToObj = new LinkedList<Type>();
	static String[] primitiveTypes = new String[] {"int","double","float","char","boolean","long"};
	
	public static void main(String[] args) {
		primitiveToObj.add(Integer.class);
		primitiveToObj.add(Double.class);
		primitiveToObj.add(Float.class);
		primitiveToObj.add(Character.class);
		primitiveToObj.add(Boolean.class);
		primitiveToObj.add(Long.class);
		System.out.println("----------------------------------------");
		System.out.println("Class name: " + Circulo.class.getSimpleName());
		System.out.println("----------------------------------------");
		System.out.println("Class package: " + Circulo.class.getPackageName());
		System.out.println("----------------------------------------");
		System.out.println("Class interfaces");
		if(Circulo.class.getInterfaces().length == 0) {
			System.out.println("Esta classe não implementa nenhuma interface");
		}
		else {
			for(Class<?> t : Circulo.class.getInterfaces()) {
				System.out.println("->" + t);
			}	
		}
		System.out.println("----------------------------------------");
		System.out.println("Class constructors");
		for(Constructor<?> c : Circulo.class.getConstructors()) {
			System.out.println("->" + c.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Class methods");
		for(Method m : Circulo.class.getDeclaredMethods()) {
			System.out.println("->" + m.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Class atributes");
		for(Field f : Circulo.class.getDeclaredFields()) {
			System.out.println("->" + f.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("\nSuper Class: " + Circulo.class.getSuperclass());
		System.out.println("----------------------------------------");
		System.out.println("Super Class constructors");
		for(Constructor<?> c : Circulo.class.getSuperclass().getConstructors()) {
			System.out.println("->" + c.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Super Class methods");
		for(Method m : Circulo.class.getSuperclass().getDeclaredMethods()) {
			System.out.println("->" + m.getName());
		}
		System.out.println("----------------------------------------");
		System.out.println("Super Class atributes");
		for(Field f : Circulo.class.getSuperclass().getDeclaredFields()) {
			System.out.println("->" + f.getName());
		}
		
		Circulo c1 = new Circulo(0,0,2);
		
		System.out.println("Nome da classe: "+c1.getClass().getName());
		System.out.println("Nome da superclasse: "+c1.getClass().getSuperclass().getName());
		Class<?>[] cls = c1.getClass().getInterfaces();
		if(cls.length!=0) {
			System.out.print("Interfaces: ");
			for(Class<?> cl : cls)
				System.out.print(cl.getName());
		}
		
		System.out.println("\n---------------------Construtores-------------------\n");
		printConstructors(c1);
		
		System.out.println("\n-----------------------Atributos--------------------\n");
		Field[] flist = c1.getClass().getDeclaredFields();
		for(Field f : flist)
			System.out.println(f.getType()+" "+f.getName());
		
		
		Method[] mlist = c1.getClass().getDeclaredMethods();
		System.out.println("\n-----------------------Métodos----------------------\n");
		for(Method m : mlist) {
			Class<?>[] clist = m.getParameterTypes();
			if(clist.length!=0) {
				System.out.print(m.getName()+ "(");
				for(int i=0;i<clist.length;i++) {
					if(i==clist.length-1)
						System.out.print(clist[i].getName() + " param"+i+")\n");
					else
						System.out.print(clist[i].getName() + " param"+i+", ");
				}	
			}
			else
				System.out.println(m.getName()+ "()");
		}
		
		
		System.out.println("\n\nCriar um objeto\nEscolha um construtor: ");
		Constructor<?>[] constlist = printConstructors(c1);
		int op = -1;
		do {
			System.out.print("\nOption-> ");
			op = in.nextInt();
		}
		while(op<0 || op>constlist.length-1);
		
		ConstParam(constlist[op]);
		
		in.close();

	}

	//imprime os construtores e os respectivos parâmetros
	public static Constructor<?>[] printConstructors(Object c1)
	{
		int cnt=0;
		Constructor<?>[] cl = c1.getClass().getDeclaredConstructors();
		for(Constructor<?> c : cl) {
			Class<?>[] start = c.getParameterTypes();
			if(start.length==0)
				System.out.print(c.getName()+"()");
			else {
				System.out.print(cnt + " -> "+c.getName()+"(");
				cnt++;
				for(int i=0;i<start.length;i++)
				{
					if(i==start.length-1)
						System.out.print(start[i].getName()+" param"+i+")\n");
					else
						System.out.print(start[i].getName()+" param"+i+", ");
				}
			}
		}
		return cl;
	}
	
	public static void ConstParam(Constructor<?> c)
	{
		Class<?>[] start = c.getParameterTypes();
		for(Class<?> cs : start)
			System.out.println(cs.getName());
	}

}
