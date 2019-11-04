package dblp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter keyword for search: ");
		String keyword = scan.nextLine();
		System.out.println("Enter tier of paper desired (0-3 available): ");
		String tierb = scan.nextLine();
		int tier = Integer.parseInt(tierb);
		scan.close();
		
		File infile = new File("input");
		String[] titles = new String[99];
		String[] authors = new String[99];
		String[] year = new String[99];
		String[] pub = new String[99];
		String[] index = new String[99];
		String[] tier1 = new String[99];
		String[] abst = new String[99];
		
		BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
		String Line =  read.readLine();
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
			if (titlecount % 2 == 0) {//even index numbers are tier 3
				tier1[titlecount] = "3";
			} else {
				tier1[titlecount] = "0"; //all else is 0
			}
			if (titlecount % 89 == 0) {//if divisible by 89 tier 2
				tier1[titlecount] = "2";
			} 
			if (titlecount % 97 == 0) {//if divisible by 97 tier 1
				tier1[titlecount] = "1";
			}
			titlecount++;
		}
		if (Line.contains("#!")) {
			abst[titlecount-1] = Line.substring(2);
		}
		
		
		Line =  read.readLine();
		}
		read.close();

		for (int i=0; i<titlecount; i++) {
			if (tier == 1) {
				if (tier1[i] == "1") {
					System.out.println("Title: " + titles[i]);
					System.out.println("Author: " + authors[i]);
					System.out.println("Year: " + year[i]);
					System.out.println("Publication: " + pub[i]);
					System.out.println("Index: " + index[i]);
					System.out.println("Abstract: " + abst[i]);
					System.out.println("Tier: " + tier1[i]);
					System.out.println();
				}
			}
			if (tier == 2) {
				if (tier1[i] == "2") {
					System.out.println("Title: " + titles[i]);
					System.out.println("Author: " + authors[i]);
					System.out.println("Year: " + year[i]);
					System.out.println("Publication: " + pub[i]);
					System.out.println("Index: " + index[i]);
					System.out.println("Abstract: " + abst[i]);
					System.out.println("Tier: " + tier1[i]);
					System.out.println();
				}
			}
			if (tier == 3) {
				if (tier1[i] == "3") {
					System.out.println("Title: " + titles[i]);
					System.out.println("Author: " + authors[i]);
					System.out.println("Year: " + year[i]);
					System.out.println("Publication: " + pub[i]);
					System.out.println("Index: " + index[i]);
					System.out.println("Abstract: " + abst[i]);
					System.out.println("Tier: " + tier1[i]);
					System.out.println();
				}
			}
			if (tier == 0) {
				if (tier1[i] == "0") {
					System.out.println("Title: " + titles[i]);
					System.out.println("Author: " + authors[i]);
					System.out.println("Year: " + year[i]);
					System.out.println("Publication: " + pub[i]);
					System.out.println("Index: " + index[i]);
					System.out.println("Abstract: " + abst[i]);
					System.out.println("Tier: " + tier1[i]);
					System.out.println();
				}
			}
		}
		
		for (int i=110; i<titlecount; i++) {
			System.out.println("Title: " + titles[i]);
			System.out.println("Author: " + authors[i]);
			System.out.println("Year: " + year[i]);
			System.out.println("Publication: " + pub[i]);
			System.out.println("Index: " + index[i]);
			System.out.println("Abstract: " + abst[i]);
			System.out.println("Tier: " + tier1[i]);
			System.out.println();
		}
		System.out.println("Keyword: " + keyword);
		System.out.println("Tier: " + tier);
	}
}
