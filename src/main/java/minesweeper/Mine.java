package minesweeper;

public class Mine extends MineSweeperCell
{

	public Mine (Matrix2DCellPosition position)
	{
		try 
		{
			setPosition(position);
			super.setValue("M");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void uncover ()
	{
		super.uncover();		
	}
	
	public void setValue (Object value) throws Exception
	{
		throw new Exception("No se puede cambiar el valor a una Mine");
		
	}
	
	public boolean isMine() {
		return true;
	}
}
