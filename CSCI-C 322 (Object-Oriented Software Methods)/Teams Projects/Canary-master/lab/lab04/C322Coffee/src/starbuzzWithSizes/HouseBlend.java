package starbuzzWithSizes;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee \nSize: " + getSize();
	}
 
	public double cost() {

		return .89;
	}
}

