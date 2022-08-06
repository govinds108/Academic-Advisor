import java.util.*;
import java.io.*;

public class FileInput {
	private College[] colleges;
	
	public static void main(String[] args) {
		
		FileInput test = new FileInput("CodedayColleges.txt");
		System.out.println(test);
	}
	
	public FileInput(String fname) {
		
		
		Scanner fileIn = null;
		Scanner fileIn2 = null;
		
		
		try {
			fileIn = new Scanner(new File(fname));
			fileIn2 = new Scanner(new File(fname));
			
		}catch(FileNotFoundException e) {
			System.exit(-1);
		}
		
		int counter = 0;
		
		while(fileIn.hasNextLine()) {
			counter++;
			fileIn.nextLine();
		}
		
		colleges = new College[counter];
		
		
		for(int i = 0; i < counter; i++) {
			String line = fileIn2.nextLine();
			int collegenum = line.indexOf("\t");
			String college = line.substring(0, collegenum);
			String newLine = line.substring(collegenum + 1, line.length());
			
			int gpa = newLine.indexOf("\t");
			double theGPA = Double.parseDouble(newLine.substring(0,gpa));
			newLine = newLine.substring(gpa + 1, newLine.length());
			
			int sat = newLine.indexOf("\t");
			int theSAT = Integer.parseInt(newLine.substring(0,sat));
			newLine = newLine.substring(sat + 1, newLine.length());
			
			int act = newLine.indexOf("\t");
			int theACT = Integer.parseInt(newLine.substring(0, act));
			newLine = newLine.substring(act + 1, newLine.length());
			
			int extraC = newLine.indexOf("\t");
			int theExtraC = Integer.parseInt(newLine.substring(0,extraC));
			newLine = newLine.substring(extraC + 1, newLine.length());
			
			double thePercentIn = Double.parseDouble(newLine);
			
			
			
			
			colleges[i] = (new College(college, theGPA, theSAT, theACT, theExtraC, thePercentIn));
		}
	}
	
	public String toString() {
		for(int i = 0; i < colleges.length; i++) {
			System.out.println(colleges[i]);
		}
		
		return "";
	}
	
	
	
	public class College {
		private String name;
		private double gpa;
		private int sat;
		private int act;
		private int extracirrics;
		private double acceptanceRate;

		public College(String n, double g, int s, int a, int e, double ac) {
			name = n;
			gpa = g;
			sat = s;
			act = a;
			extracirrics = e;
			acceptanceRate = ac;
		}
		
		public String toString() {
			return name + " " + gpa + " " + sat + " " + act + " " + extracirrics + " " + acceptanceRate;
		}


	}
}
