package headfirst.designpatterns.decorator.starbuzzWithSizes;
 
public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	public double cost() {
		double cost = beverage.cost();
		if (beverage.getSize() == Size.TALL) {
			cost += .20;
		} else if (beverage.getSize() == Size.GRANDE) {
			cost += .25;
		} else if (beverage.getSize() == Size.VENTI) {
			cost += .30;
		}
		return cost;
	}
}
