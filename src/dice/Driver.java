package dice;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	Scanner scanner = new Scanner(System.in);
	Dice dice = new Dice();
	ArrayList <Game> history = new ArrayList();
	private int counter =0;


	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.runDice();
	}

	public void runDice(){
		System.out.println("Please enter a number between 1 and 6");

		int input = Integer.parseInt(scanner.nextLine());
		int diceNumber = dice.throwDice();

		if (input < diceNumber && input > 0){
			System.out.println("You lose,"+ input+ " is less than "+diceNumber);
			Game game = new Game (input, diceNumber, "Lost");
			checkHistorySize();
			history.add(game); counter++;
		}
		else if (input > diceNumber && input < 7){
			System.out.println("You win,"+input+ " is greater than "+diceNumber);
			Game game = new Game (input, diceNumber, "Won");
			checkHistorySize();
			history.add(game); 	counter++;
		}
		else if (input == diceNumber){
			counter++;
			System.out.println("Draw,"+ input+ " is equal to "+diceNumber);
			Game game = new Game (input, diceNumber, "Draw");
			checkHistorySize();
			history.add(game); 	counter++;
		}
		else{
			runDice();

		}
		promptUser();

	}

	public void promptUser(){
		System.out.println("Would you like another game? Enter y/n, For a game history press h");
		String inputString = scanner.nextLine();

		switch(inputString){
		case "y": runDice(); break;
		case "n": System.exit(0); break;
		case "h": printHistory();
		default: ;
		}
	}

	public void printHistory(){
		for(Game games : history){
			System.out.println("Result: "+games.getResult()+
								" Input: "+games.getUserInput()+
								" Dice Result: "+ games.getDiceValue());
		}
		promptUser();
	}
	
	public void checkHistorySize(){
		if (history.size() == 10){
			history.remove(counter-10);
		}
	}

}
