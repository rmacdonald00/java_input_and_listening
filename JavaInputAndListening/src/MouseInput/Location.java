package MouseInput;
/*
 * class that contains two integers that represent the xy pixel location of a box or where a box could be
 */
public class Location {
	
	private final int xValue;
	private final int yValue;
	
	public Location(int x, int y) {
		this.xValue = x;
		this.yValue = y;
		
	}

	public int getxValue() {
		return xValue;
	}

	public int getyValue() {
		return yValue;
	}
	
}
