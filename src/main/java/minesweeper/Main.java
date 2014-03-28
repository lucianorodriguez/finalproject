package minesweeper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Enter amount of rows: ");
		int rows;
		Scanner scanRows = new Scanner(System.in);
	    rows = scanRows.nextInt();
	    
	    System.out.println("Enter amount of columns: ");
		int columns;
	    Scanner scanColumns = new Scanner(System.in);
	    columns = scanColumns.nextInt();
	    
		Grid game = new Grid(rows, columns);
		
		while (game.isGameOver() == false)
		{
			game.print();
			System.out.println("Type (u/s/c) if you want to:");
			System.out.println("     (u) Uncover");
			System.out.println("     (s) Set Flag");
			System.out.println("     (c) Clear Flag");
			
			String action;
			Scanner scanAction = new Scanner(System.in);
			action = scanAction.nextLine();
			
			if (action.equals("u") || action.equals("s") || action.equals("c"))
			{
				//User set action position
				System.out.println("Enter position:");
				
				System.out.println(     "Row:");
				int row;
				Scanner scanRow = new Scanner(System.in);
			    row = scanRow.nextInt();
			    
			    System.out.println(     "Column:");
				int column;
			    Scanner scanColumn = new Scanner(System.in);
			    column = scanColumn.nextInt();
			    
			    if ((row >= 0 && row < rows) && (column >= 0 && column< columns))
			    {		
				    //Uncover action
				    if (action.equals("u"))
				    {
				    	game.uncover(row, column);
				    }
				    
				    //Set Flag action
				    if (action.equals("s"))
				    {
				    	game.setFlag(row, column);
				    }
				    
				    //Clear Flag action
				    if (action.equals("c"))
				    {
				    	game.clearFlag(row, column);
				    }
			    }
			    else System.out.println("Invalid position");
			}
			else System.out.println("Invalid action");
			
		}
		
		game.displayInternal();
		
		if (game.isWinningGame()) System.out.println("You win, sos un capo");
		else System.out.println("You lose");
	}
	

}
