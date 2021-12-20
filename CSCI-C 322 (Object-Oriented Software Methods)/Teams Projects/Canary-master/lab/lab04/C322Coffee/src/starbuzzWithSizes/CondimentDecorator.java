package starbuzzWithSizes;

public abstract class CondimentDecorator extends Beverage {
	public Beverage beverage;
	public abstract String getDescription();
//	public double costModifier;
	
	public Size getSize() {
		return beverage.getSize();
	}
}
