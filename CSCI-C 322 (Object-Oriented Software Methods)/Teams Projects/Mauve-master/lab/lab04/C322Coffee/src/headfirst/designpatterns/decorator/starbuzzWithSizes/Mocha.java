package headfirst.designpatterns.decorator.starbuzzWithSizes;

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
			cost += .13;
		} else if (beverage.getSize() == Size.GRANDE) {
			cost += .17;
		} else if (beverage.getSize() == Size.VENTI) {
			cost += .21;
		}
		return cost;
	}
}
