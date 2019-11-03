package dblp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		File infile = new File("input");
		String[] titles = new String[99];
		String[] authors = new String[99];
		String[] year = new String[99];
		String[] pub = new String[99];
		String[] index = new String[99];
		
		BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
		String Line =  read.readLine();
		//int count = 0;
		int titlecount = 0;
		while (Line != null) {
		if (Line.contains("#*")) {
			titles[titlecount] = Line.substring(2);
		}
		if (Line.contains("#@")) {
			authors[titlecount] = Line.substring(2);
		}
		if (Line.contains("#t")) {
			year[titlecount] = Line.substring(2);
		}
		if (Line.contains("#c")) {
			pub[titlecount] = Line.substring(2);
		}
		if (Line.contains("#index")) {
			index[titlecount] = Line.substring(6);
			titlecount++; //last if needs this
		}
		
		
		Line =  read.readLine();
		//count++;
		}
		read.close();

		for (int i=0; i<titlecount; i++) {
			System.out.println("Title: " + titles[i]);
			System.out.println("Author: " + authors[i]);
			System.out.println("Year: " + year[i]);
			System.out.println("Publication: " + pub[i]);
			System.out.println("Index: " + index[i]);
			System.out.println();
		}
	}
}
