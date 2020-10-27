package aula2;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class SoupOfLetters{
	
	private char table[][];
	private ArrayList<String> words;
	private ArrayList<String> result;
	private Scanner scf;
	private final int tableWidth;
	
	public SoupOfLetters(String filename)
	{	
		result = new ArrayList<String>();
		table = new char[80][80]; //max size do puzzle 80x80
		
		try
		{
			this.scf = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e)
		{
			out.println("Ficheiro inserido não encontrado.\n");
			exit(0);
		}
		//a primeira linha define o tamanho do puzzle pois este será sempre quadrado
		String first = scf.nextLine();
		int height = 0;
		tableWidth = first.length();  
		
		int x;
		for(x = 0; x < tableWidth; x++)
		{
			table[height][x] = first.charAt(x); //definimos a primeira linha da tabela
		}
		height++;
		words = new ArrayList<String>(tableWidth);
		
		while(scf.hasNextLine())
		{
			String line = scf.nextLine();
			if(!line.contains(",")) //se não tiver vírgulas introduzimos letra a letra na tabela
			{
				for (x = 0; x < tableWidth; x++)
				{
					table[height][x] = line.charAt(x);
				}
				height++;
			}
			else
			{
				for(String word : line.split(", ")) //se tiver vírgulas, são as palavras a encontrar
				{
					words.add(word.toUpperCase());
				}
			}
		}
	}

	public void play()
	{
		int x, y;	
		for(y = 0; y < tableWidth; y++)
		{
			for (x = 0; x < tableWidth; x++)
			{
				find(x, y);
			}
		}
	}
	
	private void find(int x, int y)
	{
		for(String letter : words)
		{
			if (table[y][x] == letter.charAt(0)) //podemos começar no inicio da palavra
			{
				Point current = new Point(x, y); //coordenadas da letra onde começamos
				
				//pesquisa horizontal (x)
				if(x + letter.length() - 1 < tableWidth) 
				{
					String direction = "right";
					if(gotWords(letter, direction, current, new Point(x + letter.length(), y))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				if(x - letter.length() + 1 >= 0) 
				{ 
					String direction = "left";
					if(gotWords(letter, direction, current, new Point(x - letter.length(), y))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				
				//pesquisa vertical (y)
				if(y + letter.length() - 1 < tableWidth) 
				{
					String direction = "down";
					if(gotWords(letter, direction, current, new Point(x, y + letter.length()))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				if(y - letter.length() + 1 >= 0) 
				{
					String direction = "up";
					if(gotWords(letter, direction, current, new Point(x, y - letter.length()))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				
				//pesquisa diagonal
				if(x + letter.length() - 1 < tableWidth && y + letter.length() - 1 < tableWidth) //down + right 
				{
					String direction = "downright";
					if(gotWords(letter, direction, current,new Point(x+letter.length(), y+letter.length()))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				if(x + letter.length() - 1 < tableWidth && y - letter.length() + 1 >= 0) //up + right 
				{
					String direction = "upright";
					if(gotWords(letter, direction, current,new Point(x+letter.length(), y-letter.length()))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				if(x - letter.length() + 1 >= 0 && y + letter.length() - 1 < tableWidth) //down + left 
				{
					String direction = "downleft";
					if(gotWords(letter, direction, current,new Point(x-letter.length(), y+letter.length()))) 
					{
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
				if(x - letter.length() + 1 >= 0 && y - letter.length() + 1 >= 0) //up + left 
				{
					String direction = "upleft";
					if(gotWords(letter, direction, current,new Point(x-letter.length(), y-letter.length()))) {
						result.add(letter + "\t" + current + "\t" + direction);
					}
				}
			}
		}
	}
	
	private boolean gotWords(String letter, String direction, Point lower, Point higher) 
	{
		
		int xPlus = 0;
		int yPlus = 0;
		
		int x = lower.getX();
		int y = lower.getY();
		
		if(direction.contains("up")) {
			yPlus = -1;
		}else if(direction.contains("down")) {
			yPlus = 1;
		}
		
		if(direction.contains("left")) {
			xPlus = -1;
		}else if(direction.contains("right")) {
			xPlus = 1;
		}
		
		String almostWord = "";
		
		for(int i = 0; i < letter.length(); i++) {
			almostWord += table[y][x];
			x += xPlus;
			y += yPlus;
		}
		
		return almostWord.equals(letter);
	}
	
	public void finalResult()
	{
		for (String result : this.result)
		{
			out.println(result);
		}
		scf.close();
	}
}

class Point {
	int xx, yy;
	
    public Point(int x, int y) {
    	this.xx = x;
	    this.yy = y;
	}
    public int getX()
	{
		return xx;
	}
	
	public int getY()
	{
		return yy;
	}
    
    public String toString() {
    	return (yy+1) + "," + (xx+1);
    }
}
