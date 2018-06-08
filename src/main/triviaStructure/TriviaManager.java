package main.triviaStructure;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.Coordinate;
import graphics.GraphicObject;

import java.awt.Graphics;
import java.io.*;

public class TriviaManager extends GraphicObject{
	
		private Scanner scan = new Scanner(new File("src\\Questions"));
		private ArrayList<String> questions = new ArrayList<>();
		private ArrayList<String> choices = new ArrayList<>();
		private ArrayList<String> correctAns = new ArrayList<>();
		//ArrayList of question + while method
		private ArrayList<Boolean> check = new ArrayList<>();
		public int currentQuestionIndex;
		
		public boolean isVisible;
		
		
		public TriviaManager() throws FileNotFoundException 
		{
			super(null, new Coordinate(300, 100), 500, 315);
			//Organizes the questions / answers in different lists
			currentQuestionIndex = 0;
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
			
			//
			
		}
	
	
	
		
		//Method 2: DO NOT REPEAT QUESTION
		//ask random question
		//reroll if already used
		public String newQuestion() 
		{
			currentQuestionIndex = (int) (Math.random() * check.size());
			while (check.get(currentQuestionIndex))
			{
				currentQuestionIndex = (int) (Math.random() * check.size());
		
			}
			
			check.set(currentQuestionIndex, true);
			
			return questions.get(currentQuestionIndex);
		}
		
		public String getQuestion() {
			return questions.get(currentQuestionIndex);
		}
		
		
		public String getChoices(int num)
		{
			
			return choices.get(currentQuestionIndex * 4 + num);
		
		}
		
		public boolean isCorrect(String choice)
		{
			return (choice.equalsIgnoreCase(correctAns.get(currentQuestionIndex)));
		}
			
			
			
		public boolean checksIfQuestionUsed()
		{
			
			
			
			return false;
			
		}
		
		public void paint(Graphics graphic, int x, int y) {
			if(isVisible) {
				try {
					if(animation.getFrame() != null) {
						graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
					} else {
						graphic.setColor(color);
						graphic.fillRect(x() + x, y() + y, width, height);
					} 
				} catch (Exception e) {
					graphic.setColor(color);
					graphic.fillRect(x() + x, y() + y, width, height);
				}
				graphic.drawString(getQuestion(), x() + x, y() + y);
			}
		}
		
	
		
		//make methods small as possible	
		
		
			//Method for different situations (buy arrows, fall in hole, etc, etc etc ask Michael)
			
			
		
			
}


