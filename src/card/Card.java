package card;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Card {
	
	private Scanner scan = new Scanner(new File("src\\card\\Cards"));

	private int index = 0;
	
	private ArrayList<String> cardList = new ArrayList<>();
	private ArrayList<Integer> iDList = new ArrayList<>();
	
	
	
	public Card() throws FileNotFoundException 
	{
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
	
}

