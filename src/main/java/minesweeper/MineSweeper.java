package minesweeper;

public class MineSweeper {
	
	Grid grid;
	boolean gameOver;
	boolean winningGame;
	
	// Allow the player to uncover a cell
	void uncover(int row, int column){
		grid.uncover(row, column);;
	}
	// Marking/unmarking suspicious cells
	void setFlag(int row, int column){
		grid.setFlag(row, column);
	}
	void clearFlag(int row, int column){
		grid.clearFlag(row, column);
	}
	// Game termination
	boolean isGameOver(){
		return gameOver;
	}
	boolean isWinningGame(){
		winningGame = grid.isWinningGame();
		return winningGame;
	}
	// Operations for showing the current state of game grid
	// Public/visible grid for the player
	void display(){
		grid.print();
	}
	// Grid with all cells uncovered. For debug purposes
	void displayInternal(){
		grid.displayInternal();
	}
	// Binary grid: 1 if cell has a mine, 0 otherwise. For debug purposes
	void displayRaw(){
		grid.displayRaw();
	}
}

