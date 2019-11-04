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
		System.out.println("Enter keyword for search or nothing if not needed: ");
		String keyword = scan.nextLine(); //takes in keyword needed for search
		System.out.println("Enter tier of paper desired (0-3 available): ");
		String tierb = scan.nextLine(); //takes in tier of paper needed for search
		int tier = Integer.parseInt(tierb); //converts String to integer for later manipulation
		System.out.println();
		scan.close();
		
		File infile = new File("input");
		String[] titles = new String[99999999]; //array for titles
		String[] authors = new String[99999999]; //array for authors
		String[] year = new String[99999999]; //array for year
		String[] pub = new String[99999999]; //array for publication
		String[] index = new String[99999999]; //array for index numbers
		String[] tier1 = new String[99999999]; // array for tiers
		String[] abst = new String[99999999]; //array for abstracts
		
		BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
		String Line =  read.readLine();
		int titlecount = 0; //serves as counter of entries
		while (Line != null) {//reads from file until empty
		if (Line.contains("#*")) {//if input contains #*, append to titles array
			titles[titlecount] = Line.substring(2); //remove first two chars and insert into array
		}
		if (Line.contains("#@")) {//if input contains #@, append to authors array
			authors[titlecount] = Line.substring(2); //remove first two chars and insert into array
		}
		if (Line.contains("#t")) {//if input contains #t, append to year array
			year[titlecount] = Line.substring(2); //remove first two chars and insert into array
		}
		if (Line.contains("#c")) {//if input contains #c, append to publication array
			pub[titlecount] = Line.substring(2); //remove first two chars and insert into array
		}
		if (Line.contains("#!")) {//if input contains #!, append to abstract array
			abst[titlecount] = Line.substring(2); //remove first two chars and insert into array
		}
		if (Line.contains("#index")) {//if input contains #index, append to index array
			index[titlecount] = Line.substring(6); //remove first six chars and insert into array
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
			titlecount++; //adds one to total number of entries
		}
		
		
		Line =  read.readLine(); //retrieves next line
		}
		read.close();
		
		
		for (int i=0; i<titlecount; i++) { //print function
			if (titles[i].contains(keyword) || authors[i].contains(keyword)) {//if keyword is in title or authors name of entry, look for tier
				if (tier == 1) {
					if (tier1[i] == "1") {//if tier searched is one, print all tier ones
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
					if (tier1[i] == "2") {//if tier searched is two, print all tier twos
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
					if (tier1[i] == "3") {//if tier searched is three, print all tier threes
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
					if (tier1[i] == "0") {//if tier searched is zero, print all tier zeros
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
		}
		
		System.out.println("Keyword: " + keyword); //prints what user entered for keyword
		System.out.println("Tier: " + tier); //prints what user entered for tier
	}
}
