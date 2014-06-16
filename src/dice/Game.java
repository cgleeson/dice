package dice;

public class Game {
	
	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	public int getDiceValue() {
		return diceValue;
	}

	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private int userInput;
	private int diceValue;
	private String result;
	
	public Game(int userInput, int diceValue, String result) {
		super();
		this.userInput = userInput;
		this.diceValue = diceValue;
		this.result = result;
	}
	

}
