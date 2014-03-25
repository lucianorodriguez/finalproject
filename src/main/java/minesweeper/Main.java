package minesweeper;

public class Main {

	public static void main(String[] args) throws Exception 
	{

		Grid grid = new Grid(9, 9);
		
		grid.print();
		
		grid.uncover(0,0);
		grid.setFlag(0,1);
		grid.clearFlag(0,1);
		System.out.println("------");
		
		grid.print();
		
		System.out.println("------");
		
		grid.displayInternal();
		System.out.println("------");
		
		grid.displayRaw();
	
	}
	

}
