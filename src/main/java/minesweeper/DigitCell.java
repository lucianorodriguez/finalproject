package minesweeper;

public class DigitCell extends MineSweeperCell{
	
	public void setValue (Object value) throws Exception
	{
		Integer cellValue = (Integer) value;
		if (cellValue < 0 && cellValue > 8)
		{
			throw new Exception ("No es un valor valido para una celda de buscaminas");
		}
		this.value = cellValue;
	}

}