package starbuzzWithSizes;
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = getSize() + " Dark Roast Coffee";
	}
 
	public double cost() {
		double cost = .99;
		switch(this.getSize()){
			case TALL: cost += .05; break;
			case VENTI: cost += .10; break;
			case GRANDE: cost += .15; break;
		}
		return cost;
	}

	public void setSize(Size size) {
		this.size = size;
		description = getSize() + " Dark Roast Coffee";
	}
}

