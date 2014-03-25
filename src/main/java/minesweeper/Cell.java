package minesweeper;

public class Cell {
	
	Object value;
	Matrix2DCellPosition position;
	
	public Matrix2DCellPosition getPosition() {
		return position;
	}
	public void setPosition(Matrix2DCellPosition position) {
		this.position = position;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) throws Exception {
		this.value = value;
	}
	public String toString(){
		return this.value.toString();
	}
}
