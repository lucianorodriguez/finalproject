package minesweeper;

import com.despegar.highflight.utils.MatrixUtils;

public class ZeroCell extends DigitCell{

	public void uncover (int row, int column)
	{
		super.uncover();
		//MatrixUtils.cascade(matrix, row, column);
	}
	
	public ZeroCell (Matrix2DCellPosition position)
	{
		try {
			setPosition(position);
			super.setValue(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setValue (Object value) throws Exception
	{
		throw new Exception("No se puede cambiar el valor a Zero");		
	}
}
