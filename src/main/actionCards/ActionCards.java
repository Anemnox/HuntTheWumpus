package main.actionCards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import graphics.Coordinate;
import graphics.UserInterface.ButtonObject;
import main.wumpusConstructor.GameConstructor;

public class ActionCards extends ButtonObject {
	
	private Scanner scan = new Scanner(new File("src\\card\\Cards"));

	private int index = 0;
	
	private ArrayList<String> cardList = new ArrayList<>();
	private ArrayList<Integer> iDList = new ArrayList<>();
	
	
	private boolean isVisible;
	
	
	public ActionCards() throws FileNotFoundException 
	{
		super(GameConstructor.getAnimation(10), new Coordinate(300, 100), 780, 455);
		while (scan.hasNextLine())
		{
			cardList.add(scan.nextLine());
			iDList.add(Integer.parseInt(scan.nextLine()));
		}
		
		index = cardList.size() - 1;
	}
	public String getCard()
	{
		return cardList.get(index);
	}

	public int getIDNum()
	{
		return iDList.get(index);
	}
	
	public void nextCard()
	{
		index--;
		
		if (index < 0) {
			shuffle();
			index = cardList.size() - 1;
		}
	}
	
	private void shuffle()
	{
		ArrayList<String> tempCard = new ArrayList<>();
		ArrayList<Integer> tempID = new ArrayList<>();
		
		while (!cardList.isEmpty())
		{
			int d = (int) (Math.random() * cardList.size());
			tempCard.add(cardList.remove(d));
			tempID.add(iDList.remove(d));
		}
		cardList = tempCard;
		iDList = tempID;
	}
	
	
	public void clicked() {
		if(isVisible) {
			
		}
	}
	
	
	public void mouseHover() {
		if(isVisible) {
			
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
			graphic.drawString(getCard(), x() + x + 50, y() + y + 80);
			
			
		}
	}

		
	public void setVisible(boolean visibility) {
		isVisible = visibility;
	}

}

