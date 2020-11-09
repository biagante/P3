package aula5;

import java.io.*;

public interface FileType {

	public Pessoa[] InfoFromFile(String filename) throws IOException;
	public void InfoToFile(String filename, Pessoa[] p) throws IOException;
}
