package Week06.videoWalkthrough;

import java.util.Arrays;

public class GameBoard {
	
	String[] board = new String[9];
	
	public void initialize() {
		//fill board with numbers 1 - 9
		for(int i = 1; i <= 9; i++) {
			this.board[i - 1] = String.valueOf(i);
		}
	}
	
	public void display() {
		System.out.println("+---+---+---+");
		System.out.println("| " + this.board[0] + " | " + this.board[1] + " | " + this.board[2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + this.board[3] + " | " + this.board[4] + " | " + this.board[5] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + this.board[6] + " | " + this.board[7] + " | " + this.board[8] + " |");
		System.out.println("+---+---+---+");
	}

	public boolean ifValidSetSquare(int squareNumber, String readInput, String player) {
		// if space has the integer value the player is requesting, then it's free. if not, then it's not free
		if(this.board[squareNumber - 1].equals(readInput)) {
			this.board[squareNumber - 1] = player;
			return true;
		} else {//if square does not have integer value, then return false
			return false;
		}
	}

	public String checkWinStatus() {
		
		//8 winning combinations = iterations
		for(int pos = 0; pos < 8; pos++) {
			String winningCombo = "";
			
			//loop through 8 times, and check if there's a winning combination of either XXX OR OOO in one of the 8 winning combinations
			switch(pos) {
			case 0:
				winningCombo = this.board[0] + this.board[1] + this.board[2];
				break;
			case 1:
				winningCombo = this.board[3] + this.board[4] + this.board[5];
				break;
			case 2:
				winningCombo = this.board[6] + this.board[7] + this.board[8];
				break;
			case 3:
				winningCombo = this.board[0] + this.board[3] + this.board[6];
				break;
			case 4:
				winningCombo = this.board[1] + this.board[4] + this.board[7];
				break;
			case 5:
				winningCombo = this.board[2] + this.board[5] + this.board[8];
				break;
			case 6:
				winningCombo = this.board[0] + this.board[4] + this.board[8];
				break;
			case 7:
				winningCombo = this.board[2] + this.board[4] + this.board[6];
				break;
				
			}
			
			if(winningCombo.equals("XXX")) {
				return "X";
			}else if(winningCombo.equals("OOO")) {
				return "O";
			}
			
			
		}
		
		//see if any integers are still in array. if any numbers still remaining, game not over yet.
		for(int i = 1; i <= 9; i++) {
			if(Arrays.asList(this.board).contains(String.valueOf(i))) {
				break;
			} else if (i == 9) { //check if at last position. If no more numbers, then it's a draw
				return "draw";
			}
		}
		
		return "";
	}

}
