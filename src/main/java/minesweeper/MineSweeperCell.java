package minesweeper;

public abstract class MineSweeperCell extends Cell{

	boolean cover = true;
	boolean flag = false;
	
	public boolean isCover() {
		return cover;
	}
	public void uncover () {
		if (flag != true)
		{
			this.cover = false;
		}
		
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag() {
		this.flag = true;
	}
	public void clearFlag() {
		this.flag = false;
	}
	public boolean isMine() {
		return false;
	}
	public String toString()
	{
		if (flag == true)
		{
			return "F";
		}
		if (cover == true)
		{
			return "?";
		}
		
		return getValue().toString();
	}
}

