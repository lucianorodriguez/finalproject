package minesweeper;

import java.util.ArrayList;
import java.util.List;


public class Matrix {

	int qRow;
	int qColumn;
	
	Cell [][] matrix;
	
	public Matrix (int row,int column)
	{
		this.qRow = row;
		this.qColumn = column;
		matrix = new Cell[qRow][qColumn];
	}
	
	public Cell getCell(Matrix2DCellPosition position)
	{
		return matrix[position.getRow()][position.getColumn()];
	}
	
	
	public void setCell(Cell cell){
		
		this.matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()]=cell;
		
	}
	
	public void print()
	{
		for (int i = 0; i < matrix.length; i++) 
		{ 
            for (int j = 0; j < matrix[i].length; j++)
            {
            	System.out.print(matrix[i][j]);
            }
            
            System.out.println();
		}    
	}
	public List<Cell> getAdjacentCells (Cell cell){
		List<Cell> l = new ArrayList<Cell> ();
		
		for (int i = cell.getPosition().getRow() - 1; i <= cell.getPosition().getRow() + 1; i++) 
		{ 
            for (int j = cell.getPosition().getColumn() - 1; j <= cell.getPosition().getColumn() + 1; j++) 
            {
            	if (i >= 0 && i <= qRow - 1 && j >= 0 && j <= qColumn - 1)
            	{
            	  	if (!(cell.getPosition().getRow() == i && cell.getPosition().getColumn() == j))
            	  	{
            	  		l.add(this.matrix[i][j]);
            	  	}
            	}
            }
		}
		return l;
	}
	
}

