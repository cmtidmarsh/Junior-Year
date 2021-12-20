package headfirst.designpatterns.decorator.starbuzzWithSizes;

public class Decaf extends Beverage {
	public Decaf() {
		description = getSize() + " Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

