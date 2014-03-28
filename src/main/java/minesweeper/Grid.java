package minesweeper;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.despegar.highflight.utils.Matrix2DCellPosition;
import com.despegar.highflight.utils.MatrixUtils;

public class Grid extends Matrix {

	int[][] binaryMatrix;
	
	public Grid(int row, int column) throws Exception
	{
		super(row, column);
		Random rand = new Random();
		Random rand2 = new Random();
		int k = Math.round(row * column * 15 / 100);
		
		//this binary matrix returns 1 for mines, this is used for cascade
		binaryMatrix = new int[row][column];
		
		while (0 < k)
		{
			for (int i = 0 ; i < k ; i++)
			{			
				int row1 = rand.nextInt(row);
				int column1 = rand2.nextInt(column);
				Mine mine = new Mine(new Matrix2DCellPosition(row1, column1));
				setCell(mine);
			}
			for (int i = 0; i < matrix.length; i++) 
			{ 
	            for (int j = 0; j < matrix[i].length; j++)
	            {
	            	Cell cell = getCell(new Matrix2DCellPosition(i, j));
					MineSweeperCell mscell = (MineSweeperCell) cell;
					if (mscell != null && mscell.isMine())	k--;
	            }
			}
			
		}
		//Mines already set
		
		 
		
		for (int i = 0 ; i < matrix.length ; i++)
		{
			for (int j = 0 ; j < matrix[i].length ; j++)
			{
				if (getCell(new Matrix2DCellPosition(i, j)) == null)
				{
					Integer mineCounter = 0;
					DigitCell dc = new DigitCell();
					dc.setPosition(new Matrix2DCellPosition(i, j));
					List<Cell> cells = getAdjacentCells(dc);
					for (Cell cell : cells)
					{
						MineSweeperCell mscell = (MineSweeperCell) cell;
						if (mscell != null && mscell.isMine())
						{
							mineCounter ++;
						}
					}
					dc.setValue(mineCounter);
					setCell(dc);
					if (mineCounter == 0)
					{
						ZeroCell zc = new ZeroCell(new Matrix2DCellPosition(i, j));
						setCell(zc);
					}
					
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) 
		{ 
            for (int j = 0; j < matrix[i].length; j++)
            {
            	Cell cell = getCell(new Matrix2DCellPosition(i, j));
				MineSweeperCell mscell = (MineSweeperCell) cell;
				if (mscell.isMine())	binaryMatrix[i][j] = 1;
				else	binaryMatrix[i][j] = 0;
            }
           
		} 
		
	}
	
	public void uncover (int row, int column)
	{
		Cell cell =	getCell(new Matrix2DCellPosition(row, column));
		MineSweeperCell mscell = (MineSweeperCell) cell;
		mscell.uncover();
		if (mscell instanceof ZeroCell){
			Set<Matrix2DCellPosition> cascadeSet = MatrixUtils.cascade(binaryMatrix, row, column);
			for (Matrix2DCellPosition cascadePosition : cascadeSet)
			{
				Cell cell2 =	getCell(cascadePosition);
				MineSweeperCell mscell2 = (MineSweeperCell) cell2;
				mscell2.uncover();
			}
			//me devuelve un set de posiciones que tienen que ser descubiertas
		}
	}
	public void setFlag(int row, int column)
	{
		Cell cell = getCell(new Matrix2DCellPosition(row, column));
		MineSweeperCell mscell = (MineSweeperCell) cell;
		mscell.setFlag();
	}
	public void clearFlag(int row, int column) {
		Cell cell = getCell(new Matrix2DCellPosition(row, column));
		MineSweeperCell mscell = (MineSweeperCell) cell;
		mscell.clearFlag();
	}

	public boolean isWinningGame() 
	{
		int coveredCells = 0;
		for (int i = 0 ; i < matrix.length ; i++)
		{
			for (int j = 0 ; j < matrix[i].length ; j++)
			{
				
				Cell cell = getCell(new Matrix2DCellPosition(i, j));
				MineSweeperCell mscell = (MineSweeperCell) cell;
				if (mscell.isMine() == false && mscell.isCover() == true)
				{
					coveredCells ++;
					if (coveredCells == 1) return false;
				}
					
			}
		}
		return true;
		
	}
	
	public boolean isGameOver() 
	{
		for (int i = 0; i < matrix.length; i++) 
		{ 
            for (int j = 0; j < matrix[i].length; j++)
            {
				Cell cell = getCell(new Matrix2DCellPosition(i, j));
				MineSweeperCell mscell = (MineSweeperCell) cell;
				if (mscell.isMine() == true && mscell.isCover() == false)
				{
					return true;
				}
            }
		}
		if (isWinningGame() == true) 	return true;
		
		return false;
	}

	public void displayInternal() {
		for (int i = 0; i < matrix.length; i++) 
		{ 
            for (int j = 0; j < matrix[i].length; j++)
            {
            	System.out.print(getCell(new Matrix2DCellPosition(i, j)).getValue());
            }
            
            System.out.println();
		}    
		
	}

	public void displayRaw() {
		for (int i = 0; i < matrix.length; i++) 
		{ 
            for (int j = 0; j < matrix[i].length; j++)
            {
            	Cell cell = getCell(new Matrix2DCellPosition(i, j));
				MineSweeperCell mscell = (MineSweeperCell) cell;
				if (mscell.isMine() == true)	System.out.print(1);
				else	System.out.print(0);
            }
            
            System.out.println();
		}  
		
	}

	
	
}

