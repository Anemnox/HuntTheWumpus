package triviaStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Question {
	public static void main (String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("C:\\Users\\sn373546\\Documents\\GitHub\\HuntTheWumpus\\Trivia\\bin\\Questions"));
		ArrayList<String> questions = new ArrayList<>();
		ArrayList<String> choices = new ArrayList<>();
		ArrayList<String> correctAns = new ArrayList<>();
		//ArrayList of question + while method
		//Organizes the questions / answers in different lists
		while (scan.hasNextLine())
			{
				questions.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				correctAns.add(scan.nextLine());
			}
				
		for (String q : questions) System.out.println(q);
		
		
		//Method 2: DO NOT REPEAT QUESTION
		
		
		
		
		
		
		//Method for different situations (buy arrows, fall in hole, etc, etc etc ask Michael)
		
		
	
		
	}

}
