
import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;


public class AcademicAdvisor extends JFrame implements ActionListener {

	College[] colleges;
	String[] collegeNames;
	
	DefaultComboBoxModel theModel;
	JTextField jtfSAT;
	JTextField jtfACT;
	JButton submit;
	JComboBox theBox;
	JLabel results;
	JLabel selectedCollege;
	JTextField jtfGPA;
	JTextField jtfExtCur;
	JLabel[] priorityList;
	
	public AcademicAdvisor(){	
		
		
		Scanner fileIn = null;
		Scanner fileIn2 = null;
		
		
		try {
			fileIn = new Scanner(new File("CodedayColleges.txt"));
			fileIn2 = new Scanner(new File("CodedayColleges.txt"));
			
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
		
		collegeNames = new String[colleges.length];
		
		for (int i = 0; i < colleges.length; i++)
			collegeNames[i] = colleges[i].name;
		
		// this title will appear on the top of the frame
		setTitle("Academic Advisor");	
		
		// ensures that the program will terminate when the user closes the gui
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//the dimensions of the frame
		setSize(1000,700);
		setLocation(0, 0);
		
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		
	  	JLabel display = new JLabel("Academic Advisor");
	  	display.setBounds(325, -200, 650, 500);
	   	display.setFont(new Font("Arial",Font.BOLD,40));

	   	JLabel selectCollege = new JLabel("Select College: ");
	   	selectCollege.setBounds(200, -80, 200, 450);	   	
	   	selectCollege.setFont(new Font("Arial",Font.BOLD,16));
	   	
	   	collegeNames[0] = collegeNames[0].substring(3);
	   	colleges[0].name = collegeNames[0];
	   	
	   	theModel = new DefaultComboBoxModel(collegeNames);
	   	theBox = new JComboBox(theModel);
		theBox.setBounds(350, 138, 400, 20);
		
	   	JLabel satInputLabel = new JLabel("SAT SCORE: ");
	   	satInputLabel.setBounds(200, -80, 650, 500);
	   	satInputLabel.setFont(new Font("Arial",Font.BOLD,16));
	   	
	   	jtfSAT = new JTextField(20);
	   	jtfSAT.setBounds(310, 163, 50, 20);
	   		   	
	   	JLabel actInputLabel = new JLabel("ACT SCORE: ");
	   	actInputLabel.setBounds(200, -55, 650, 500);
	   	actInputLabel.setFont(new Font("Arial",Font.BOLD,16));
		
	   	jtfACT = new JTextField(20);
	   	jtfACT.setBounds(310, 187, 50, 20);
	   	
	   	JLabel gpaInput = new JLabel("GPA (Out of 4) : ");
	   	gpaInput.setBounds(200, -30, 650, 500);
	   	gpaInput.setFont(new Font("Arial",Font.BOLD,16));
	   	
	   	jtfGPA = new JTextField(20);
	   	jtfGPA.setBounds(320, 211, 50, 20);
	   	
	   	JLabel extCurInput = new JLabel("Number of Extracurriculars: ");
	   	extCurInput.setBounds(200, -5, 650, 500);
	   	extCurInput.setFont(new Font("Arial",Font.BOLD,16));

	   	jtfExtCur = new JTextField(20);
	   	jtfExtCur.setBounds(415, 235, 50, 20);
	   	
	   	submit = new JButton("SUBMIT!");
	   	submit.setBounds(420, 270, 150, 50);
	   	submit.addActionListener(this);
	   	
	   	selectedCollege = new JLabel("");
	   	selectedCollege.setBounds(200, 125, 650, 500);
	   	selectedCollege.setFont(new Font("Arial",Font.BOLD, 20));
	   	
	   	
	   	results = new JLabel("");
	   	results.setBounds(200, 160, 650, 500);
	   	results.setFont(new Font("Arial",Font.BOLD,20));

	   	priorityList = new JLabel[3];
	   	
	   	priorityList[0] = new JLabel("");
	   	priorityList[0].setBounds(200, 200, 650, 500);
	   	priorityList[0].setFont(new Font("Arial",Font.BOLD,20));
		
	   	
	   	priorityList[1] = new JLabel("");
	   	priorityList[1].setBounds(200, 230, 650, 500);
	   	priorityList[1].setFont(new Font("Arial",Font.BOLD,20));
	   	
	   	
	   	priorityList[2] = new JLabel("");
	   	priorityList[2].setBounds(200, 260, 650, 500);
	   	priorityList[2].setFont(new Font("Arial",Font.BOLD,20));
	   	
	   	
	   	
	  	add(display);
	  	add(selectCollege);
	  	add(theBox);

	  	add(satInputLabel);
	  	add(jtfSAT);
	  	add(actInputLabel);
	  	add(jtfACT);
	  	add(gpaInput);
	  	add(jtfGPA);
	  	add(extCurInput);
		add(jtfExtCur);
		add(submit);
		add(selectedCollege);
		add(results);
		add(priorityList[2]);
		add(priorityList[1]);
		add(priorityList[0]);

		setVisible(true);
	}
	
	public static void main(String[] args){
		
		AcademicAdvisor bd = new AcademicAdvisor();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String collegeName = (String)theBox.getSelectedItem();
		
		College curCollege = null;
		
		for (int i = 0; i < colleges.length; i++) {
			
			if (collegeName.equals(colleges[i].name))
				curCollege = colleges[i];
			
		}
		
		System.out.println(curCollege);
		
		selectedCollege.setText("SELECTED COLLEGE: " + curCollege.name);
		results.setText("Priority List: ");
		
		double testScorePer = 0;
		
		if (jtfSAT.getText().length() != 0)
			testScorePer = (double)(Integer.parseInt(jtfSAT.getText())/curCollege.sat);
		
		double temp = 0;
		if (jtfACT.getText().length() != 0)
			temp = (double)(Integer.parseInt(jtfACT.getText())/curCollege.act);

		if (temp > testScorePer)
			testScorePer = temp;
		
		double gpaPer = (double)(Double.parseDouble(jtfGPA.getText())/curCollege.gpa);
		
		double extPer = (double)(Integer.parseInt(jtfExtCur.getText())/curCollege.extracirrics);
		
		
		PriorityQueue queue = new PriorityQueue();
	
		
		queue.add(testScorePer);
		queue.add(gpaPer);
		queue.add(extPer);
		
		System.out.println(queue.peek());
		if ((double)queue.peek() >= 1) {
			priorityList[0].setText("YOUR ALL GOOD");
			return;
		}
		for (int i = 0; i < priorityList.length; i++) {
			
			double val = (double) queue.remove();
			
			if (val == testScorePer)
				priorityList[i].setText("IMPROVE YOUR TEST SCORE");
			
			if (val == gpaPer)
				priorityList[i].setText("INCREASE YOUR GPA");
			System.out.println(extPer);
			System.out.println(val);
			if (val == extPer)
				priorityList[i].setText("TAKE MORE EXTRACURRICULARS");
		}
		
		
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