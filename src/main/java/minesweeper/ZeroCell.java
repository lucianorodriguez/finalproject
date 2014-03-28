package minesweeper;

import com.despegar.highflight.utils.Matrix2DCellPosition;

public class ZeroCell extends DigitCell{

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
