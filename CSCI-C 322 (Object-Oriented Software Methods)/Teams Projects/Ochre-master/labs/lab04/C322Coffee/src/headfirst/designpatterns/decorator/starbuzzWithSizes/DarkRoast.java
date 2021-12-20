package headfirst.designpatterns.decorator.starbuzzWithSizes;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = getSize() + " Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

