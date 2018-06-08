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
		public String answer;
		
		
		public boolean isVisible;
		
		//
		public Coordinate mouseCoords;
		public Coordinate mouseRelCamera;
		
		public ArrayList<ButtonObject> listOfButtons;
		
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
			listOfButtons = new ArrayList<>();
		}
	
	
	
		
		//Method 2: DO NOT REPEAT QUESTION
		//ask random question
		//reroll if already used
		public String newQuestion() {
			currentQuestionIndex = (int) (Math.random() * check.size());
			while (check.get(currentQuestionIndex))
			{
				currentQuestionIndex = (int) (Math.random() * check.size());
		
			}
			answer = "";
			check.set(currentQuestionIndex, true);
			
			return questions.get(currentQuestionIndex);
		}
		
		public String getQuestion() {
			return questions.get(currentQuestionIndex);
		}
		
		
		public String getChoices(int num) {
			return choices.get(currentQuestionIndex * 4 + num);
		
		}
		

		public void setAnswer(String string) {
			// TODO Auto-generated method stub
			answer = string;
		}
		
		public boolean isCorrect(String choice) {
			return (choice.equalsIgnoreCase(correctAns.get(currentQuestionIndex)));
		}
			

		public int getResult() {
			if(answer != "") {
				if(isCorrect(answer)) {
					return 1;
				} else {
					return 0;
				}
			} 
			return -1;
		}	
			
		public boolean checksIfQuestionUsed() {
			return false;	
		}
		
		
		
		//
		//		Buttons
		//
		
		public void addButton(ButtonObject button) {
			listOfButtons.add(button);
		}
		
		public ArrayList<ButtonObject> getButtons() {
			return listOfButtons;
		}
		
		//
		//		Button Clicks
		//
		
		
		//
		//		Mouse Click Checks
		//
		
		public boolean pointTouch(Coordinate coords) {
			mouseCoords = new Coordinate(coords.getX(), coords.getY());
			return super.pointTouch(coords);
		}
		
		public void clicked() {
			if(isVisible) {
				//super.clicked();
				mouseRelCamera = new Coordinate(
						mouseCoords.getX() - coords.getX(),
						mouseCoords.getY() - coords.getY());
				//System.out.println(mouseRelCamera);
				for(ButtonObject button : listOfButtons) {
					if(button.pointTouch(mouseRelCamera)) {
						//System.out.println("Cave " + cave.caveID + " was clicked");
						
						button.clicked();
					} else {
						button.noContact();
					}
				}
			}
		}
		
		
		public void mouseHover() {
			if(isVisible) {
				mouseRelCamera = new Coordinate(
						mouseCoords.getX() - coords.getX(),
						mouseCoords.getY() - coords.getY());
				
				for(ButtonObject button : listOfButtons) {	
					if(button.pointTouch(mouseRelCamera)) {
						//System.out.println("Hovering over cave " + cave.caveID);
						button.mouseHover();
					} else {
						button.noContact();
					}
				}
			}
		}

		public void update(double tick) {
			for(ButtonObject object : listOfButtons) {
				object.update(tick);
			}
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
				graphic.drawString("" + mouseRelCamera, x() + x + 10, y() + y - 40);

				graphic.drawString(getQuestion(), x() + x + 50, y() + y + 80);
				for(int i = 0; i < 4; i++) {
					graphic.drawString(getChoices(i), x() + x + 80, y() + y + 130 + (40 * i)); 
				}
				for(ButtonObject button : listOfButtons) {
					button.paint(graphic, x() + x, y() + y);
				}
				
			}
		}
	
			
		public void setVisible(boolean visibility) {
			isVisible = visibility;
		}




		
			
}


