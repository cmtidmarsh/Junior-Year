package starbuzzWithSizes;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee \nSize: " + getSize();
	}
 
	public double cost() {
		return .99;
	}
}

