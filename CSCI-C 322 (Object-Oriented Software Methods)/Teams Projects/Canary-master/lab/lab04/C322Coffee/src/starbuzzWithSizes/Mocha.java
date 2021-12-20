package starbuzzWithSizes;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		double cost = beverage.cost();
		if (beverage.getSize() == Size.TALL) {
			cost += .20;
		} else if (beverage.getSize() == Size.GRANDE) {
			cost += .30;
		} else if (beverage.getSize() == Size.VENTI) {
			cost += .40;
		}
		return  cost;
	}
}
