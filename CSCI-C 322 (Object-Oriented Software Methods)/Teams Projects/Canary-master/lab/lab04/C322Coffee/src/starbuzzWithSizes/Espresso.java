package starbuzzWithSizes;

public class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}

	public void setSize(Size size) {
		this.size = Size.TALL;
	}
  
	public double cost() {
		return 1.99;
	}
}

