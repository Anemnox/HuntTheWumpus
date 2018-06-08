package main.actionCards;

import java.io.FileNotFoundException;

import main.actionCards.ActionCards;

public class CardTester {
	public static void main(String[] args) throws FileNotFoundException
	{
		ActionCards q = new ActionCards();
		
		System.out.println(q.getCard());
	}

}


