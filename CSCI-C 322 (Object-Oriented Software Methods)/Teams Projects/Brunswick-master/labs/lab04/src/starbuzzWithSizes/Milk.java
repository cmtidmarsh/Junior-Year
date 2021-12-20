package starbuzzWithSizes;
public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		double cost = .10;
		switch(this.getSize()){
			case TALL: cost += .03; break;
			case VENTI: cost += .06; break;
			case GRANDE: cost += .09; break;
		}
		return cost;
	}
}
