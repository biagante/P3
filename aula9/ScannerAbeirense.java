package aula9;

import java.util.*;
import java.io.*;

public class ScannerAbeirense implements Iterator<String>, Closeable{
	
	Scanner read;
	
	public ScannerAbeirense() {
		read = new Scanner(System.in);
	}
	
	public ScannerAbeirense(File f) throws IOException {
		read = new Scanner(f);
	}
	
	@Override
	public void close() throws IOException{
		read.close();
	}
	
	@Override
	public boolean hasNext() {
		if(read.hasNext()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String next() {
		String original = read.next();
		String result = original.replaceAll("v", "b");
		result = result.replaceAll("V", "B");
		return result;				
	}
	
	public String nextLine() {
		String original = read.nextLine();
		String result = original.replaceAll("v", "b");
		result = result.replaceAll("V","B");
		return result;
	}
}

