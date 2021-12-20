package starbuzzWithSizes;
public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		double cost = .10;
		switch(this.getSize()){
			case TALL: cost += .15; break;
			case VENTI: cost += .20; break;
			case GRANDE: cost += .25; break;
		}
		return cost;
	}
}
