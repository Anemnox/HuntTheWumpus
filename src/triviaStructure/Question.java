package triviaStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Question {
	
		private Scanner scan = new Scanner(new File("src\\Questions"));
		private ArrayList<String> questions = new ArrayList<>();
		private ArrayList<String> choices = new ArrayList<>();
		private ArrayList<String> correctAns = new ArrayList<>();
		//ArrayList of question + while method
		private ArrayList<Boolean> check = new ArrayList<>();
		public int index = 0;
		
		public Question() throws FileNotFoundException 
		{
		//Organizes the questions / answers in different lists
		while (scan.hasNextLine())
			{
				questions.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				choices.add(scan.nextLine());
				correctAns.add(scan.nextLine());
				//Adds to array to make every unused question false
				check.add(false);
							
			}
			
		//checks if while works
		//for (String q : questions) System.out.println(q);
	}
		
		
		//Method 2: DO NOT REPEAT QUESTION
		//ask random question
		//reroll if already used
		public String getQuestion() 
		{
			index = (int) (Math.random() * check.size());
			while (check.get(index))
			{
				index = (int) (Math.random() * check.size());
		
			}
			
			check.set(index, true);
			
			return questions.get(index);
		}
		
		
		public String getChoices(int num)
		{
			
			return choices.get(index * 4 + num);
		
		}
		
		public boolean isCorrect(String choice)
		{
			return (choice.equalsIgnoreCase(correctAns.get(index)));
		}
		
		
		
	public boolean checksIfQuestionUsed()
	{
		
		
		
		return false;
		
	}
	
	
	

	
	//make methods small as possible	
	
	
		//Method for different situations (buy arrows, fall in hole, etc, etc etc ask Michael)
		
		
	
		
	}


