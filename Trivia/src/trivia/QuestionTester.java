package trivia;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionTester {
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		Question quest = new Question();
		String ans;
		
		System.out.println(quest.getQuestion());
		System.out.println(quest.getChoices(0));
		System.out.println(quest.getChoices(1));
		System.out.println(quest.getChoices(2));
		System.out.println(quest.getChoices(3));
		
		ans = scan.nextLine();
		System.out.println(quest.isCorrect(ans));
	}

}
