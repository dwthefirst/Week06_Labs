package Week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	//instance variables
	
	//a string array with index 0-8 (1-9) that represents the position of the gameboard
	private String[] gameBoard = new String[9];

	private String[] player1 = new String[9]; //choices for player 1

	private String[] player2 = new String[9];

	
	//constructor
	//intialize gameBoard String array with indexes?
	public GameBoard() {
		for(int i = 0; i < gameBoard.length; i++){
			gameBoard[i] = Integer.toString(i + 1);
		}
	}

	//methods
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("+---+---+---+");
		System.out.println("| 1 | 2 | 3 |");
		System.out.println("+---+---+---+");
		System.out.println("| 4 | 5 | 6 |");
		System.out.println("+---+---+---+");
		System.out.println("| 7 | 8 | 9 |");
		System.out.println("+---+---+---+");
	}

	public void display2(){
		System.out.println("+---+---+---+");
		System.out.println("| " + this.gameBoard[0] + " | " + this.gameBoard[1] + " | " + this.gameBoard[2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + this.gameBoard[3] + " | " + this.gameBoard[4] + " | " + this.gameBoard[5] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + this.gameBoard[6] + " | " + this.gameBoard[7] + " | " + this.gameBoard[8] + " |");
		System.out.println("+---+---+---+");
	}
	
	
	//check if there is already an X or O in the spot passed in as a parameter and have them loop again	
	public boolean isPositionAvailable(int input) {
		if(this.gameBoard[input - 1] == "X" || this.gameBoard[input - 1] == "O") { //if taken
//			System.out.println("That spot has already been taken. Please try again.");
			return false;
		} else {
			return true;
		}
	}

	//the String array is bascially the number positions in the tic tac toe grid
	//all you have to do is keep track of the grid.
	//player 1 is X and player 2 is O and you can just change that in the grid array because its a string array.

	/*
		Then you can literally just check the indexes and check if the winning combo of the INDEXES matches X or O
		And I guess the player 1 and player 2 will just alternate in a loop or something being X or O?
	 */
	public boolean playerTurnX(int input){			
		if(isPositionAvailable(input) ==  true) {
			this.gameBoard[input - 1] = "X";
			display2();
			return true;
		} else { //spot already taken
//			System.out.println("That spot has already been taken. Please try again.");
			return false;
			
		}
		
		
		
		
	}

	public boolean playerTurnO(int input){
		if(isPositionAvailable(input) == true) { //if the position is avaialable, then change it to O and display updated grid again
			this.gameBoard[input - 1] = "O";
			display2();
			return true;
		} else {
			return false;
		}
		
		
	}

	public boolean checkForWin(){
		/*
		Winning Combinations
			1, 2, 3 (horizontal)    x
			4, 5, 6 (horizontal)    x 
			7, 8, 9 (horizontal)    x
			1, 4, 7 (vertical)      x
			2, 5, 8 (vertical)      x
			3, 6, 9 (vertical)      x
			1, 5, 9 (diagonal)      x
			3, 5, 7 (diagonal)      x

		 */
		
		//REMEMBER TO SUBTRACT 1 FOR THE POSITION BECAUSE ITS A STRING ARRAY (0 INDEX BASED)

		//X win on the top row - positions: 1, 2, 3
		if((this.gameBoard[0].equals("X")) && (this.gameBoard[1].equals("X"))  && (this.gameBoard[2].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE TOP ROW!");
			return true;
		}
		
		//O win on the top row - positions: 1, 2, 3
		if((this.gameBoard[0].equals("O")) && (this.gameBoard[1].equals("O"))  && (this.gameBoard[2].equals("O") )){
			System.out.println("Player 2 (O) WINS ON THE TOP ROW!");
			return true;
		}
		
		
		//X win on the MIDDLE row - positions: 4, 5, 6   Indexes (3, 4, 5)
		if((this.gameBoard[3].equals("X")) && (this.gameBoard[4].equals("X"))  && (this.gameBoard[5].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE MIDDLE ROW!");
			return true;
		}
		
		//O win on the MIDDLE row - positions: 4, 5, 6      Indexes (3, 4, 5)
		if((this.gameBoard[3].equals("O")) && (this.gameBoard[4].equals("O"))  && (this.gameBoard[5].equals("O") )){
			System.out.println("Player 2 (O) WINS ON THE MIDDLE ROW!");
			return true;
		}
		
		
		//X win on the BOTTOM row - positions: 7, 8, 9   Indexes (6, 7, 8)
		if((this.gameBoard[6].equals("X")) && (this.gameBoard[7].equals("X"))  && (this.gameBoard[8].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE BOTTOM ROW!");
			return true;
		}
		
		//O win on the BOTTOM row - positions: 7, 8, 9   Indexes (6, 7, 8)
		if((this.gameBoard[6].equals("O")) && (this.gameBoard[7].equals("O"))  && (this.gameBoard[8].equals("O") )){
			System.out.println("Player 2 (O) WINS ON THE BOTTOM ROW!");
			return true;
		}
		
		
		//X win on the first column - positions 1, 4, 7    Indexes (0, 3, 6)
		if((this.gameBoard[0].equals("X")) && (this.gameBoard[3].equals("X"))  && (this.gameBoard[6].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE FIRST COLUMN!");
			return true;
		}
		
		//O win on the first column - positions 1, 4, 7    Indexes (0, 3, 6)
		if((this.gameBoard[0].equals("O")) && (this.gameBoard[3].equals("O"))  && (this.gameBoard[6].equals("O") )){
			System.out.println("Player 2 (0) WINS ON THE FIRST COLUMN!");
			return true;
		}
		
		
		//X win on the MIDDLE column - positions 2, 5, 8    Indexes (1, 4, 7)
		if((this.gameBoard[1].equals("X")) && (this.gameBoard[4].equals("X"))  && (this.gameBoard[7].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE MIDDLE COLUMN!");
			return true;
		}
		
		//O  win on the MIDDLE column - positions 2, 5, 8    Indexes (1, 4, 7)
		if((this.gameBoard[1].equals("O")) && (this.gameBoard[4].equals("O"))  && (this.gameBoard[7].equals("O") )){
			System.out.println("Player 2 (0) WINS ON THE MIDDLE COLUMN!");
			return true;
		}
		
		
		//X win on the LAST column - positions 3, 6, 9    Indexes (2, 5, 8)
		if((this.gameBoard[2].equals("X")) && (this.gameBoard[5].equals("X"))  && (this.gameBoard[8].equals("X") )){
			System.out.println("Player 1 (X) WINS ON THE LAST COLUMN!");
			return true;
		}
		
		//O win on the LAST column - positions 3, 6, 9    Indexes (2, 5, 8)
		if((this.gameBoard[2].equals("O")) && (this.gameBoard[5].equals("O"))  && (this.gameBoard[8].equals("O") )){
			System.out.println("Player 2 (0) WINS ON THE LAST COLUMN!");
			return true;
		}
		
		
		
		//X win diagonal 1 - positions 1, 5, 9    Indexes (0, 4, 8)
		if((this.gameBoard[0].equals("X")) && (this.gameBoard[4].equals("X"))  && (this.gameBoard[8].equals("X") )){
			System.out.println("Player 1 (X) WINS DIAGONALLY 1!");
			return true;
		}
		
		//O win diagonal 1 - positions 1, 5, 9    Indexes (0, 4, 8)
		if((this.gameBoard[0].equals("O")) && (this.gameBoard[4].equals("O"))  && (this.gameBoard[8].equals("O") )){
			System.out.println("Player 2 (0) WINS DIAGONALLY 1!");
			return true;
		}
		
		
		
		//X win diagonal 2 - positions 3, 5, 7    Indexes (2, 4, 6)
		if((this.gameBoard[2].equals("X")) && (this.gameBoard[4].equals("X"))  && (this.gameBoard[6].equals("X") )){
			System.out.println("Player 1 (X) WINS DIAGONALLY 2!");
			return true;
		}
		
		//O win diagonal 2 - positions 3, 5, 7    Indexes (2, 4, 6)
		if((this.gameBoard[2].equals("O")) && (this.gameBoard[4].equals("O"))  && (this.gameBoard[6].equals("O") )){
			System.out.println("Player 2 (0) WINS DIAGONALLY 2!");
			return true;
		}
		
		
		
		return false;
	}
	
	//how to check for draw
	public boolean checkForDraw() {
		
		
		//make a string array that will put in X or O if it matches X or O in the gameBoard String array.
		//check if the length of that array is 9. if it is, then all the positions are filled. and it is a draw.
		//Because checkForWin should stop the game if someone wins
		List<String> draw = new ArrayList<>();
		
		//loop through every String element in the array which represents our tic tac toe grid
		for(int i = 0; i < this.gameBoard.length; i++) {
			//check if it's X or O.
			if(this.gameBoard[i].equals("X") || this.gameBoard[i].equals("O")) {
				draw.add("X");
			}
		}
		
		//check if the length of that array is 9. if it is, then all the positions are filled. and it is a draw.
//		System.out.println("draw array: " + draw.toString());
//		System.out.println("draw array size: " + draw.size());
		if(draw.size() == 9) {
			return true;
		} else {
			return false;
		}
		
		
		
		//
	}
	
	
}
