package dblp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		File infile = new File("input");
		
		BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
		String Line =  read.readLine();
		while (Line != null) {
		System.out.println(Line);
		Line =  read.readLine();
		}
		read.close();
	}
}
