package main.triviaStructure;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.Coordinate;
import graphics.UserInterface.ButtonObject;
import graphics.UserInterface.GameButtonObject;
import main.gameboardEntities.Cave;
import main.wumpusConstructor.GameConstructor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.*;

public class TriviaManager extends ButtonObject{
	
		private Scanner scan = new Scanner(new File("src\\Questions"));
		private ArrayList<String> questions = new ArrayList<>();
		private ArrayList<String> choices = new ArrayList<>();
		private ArrayList<String> correctAns = new ArrayList<>();
		//ArrayList of question + while method
		private ArrayList<Boolean> check = new ArrayList<>();
		public int currentQuestionIndex;
		
		
		
		public boolean isVisible;
		
		//
		public Coordinate mouseCoords;
		public Coordinate mouseRelCamera;
		
		public ArrayList<GameButtonObject> listOfButtons;
		
		public TriviaManager() throws FileNotFoundException 
		{
			super(GameConstructor.getAnimation(10), new Coordinate(300, 100), 780, 455);
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
					graphic.setColor(Color.BLACK);
					graphic.setFont(new Font("showcard gothic", Font.PLAIN, 24));

					if(animation.getFrame() != null) {
						graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
					} else {
						graphic.fillRect(x() + x, y() + y, width, height);
					} 
				} catch (Exception e) {
					graphic.setColor(color);
					graphic.fillRect(x() + x, y() + y, width, height);
				}
				graphic.drawString(getQuestion(), x() + x + 50, y() + y + 80);
				for(int i = 0; i < 4; i++) {
					graphic.drawString(getChoices(i), x() + x + 80, y() + y + 130 + (40 * i)); 
				}
			}
		}
		
		//
		//		Mouse Click Checks
		//
		
		public void clicked() {
			//super.clicked();
			mouseRelCamera = new Coordinate(
					mouseCoords.getX() - coords.getX(),
					mouseCoords.getY() - coords.getY());
			//System.out.println(mouseRelCamera);
			for(GameButtonObject button : listOfButtons) {
				if(button.pointTouch(mouseRelCamera)) {
					//System.out.println("Cave " + cave.caveID + " was clicked");
					
					button.clicked();
				} else {
					button.noContact();
				}
			}
		}
		
		public void mouseHover() {
			mouseRelCamera = new Coordinate(
					mouseCoords.getX() - coords.getX(),
					mouseCoords.getY() - coords.getY());
			
			for(GameButtonObject button : listOfButtons) {	
				if(button.pointTouch(mouseRelCamera)) {
					//System.out.println("Hovering over cave " + cave.caveID);
					button.mouseHover();
				} else {
					button.noContact();
				}
			}
		}
			
			
		public void setVisible(boolean visibility) {
			isVisible = visibility;
		}
		
			
}


