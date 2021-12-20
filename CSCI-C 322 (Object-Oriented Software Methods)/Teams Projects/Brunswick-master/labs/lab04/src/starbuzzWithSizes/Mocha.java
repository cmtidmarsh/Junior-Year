package starbuzzWithSizes;
public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		double cost = .20;
		switch(this.getSize()){
			case TALL: cost += .25; break;
			case VENTI: cost += .30; break;
			case GRANDE: cost += .35; break;
		}
		return cost;
	}
}
