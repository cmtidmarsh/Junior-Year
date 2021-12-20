package starbuzzWithSizes;
public class Decaf extends Beverage {
	public Decaf() {
		description = getSize() + " Decaf Coffee";
	}
 
	public double cost() {
		double cost = 1.05;
		switch(this.getSize()){
			case TALL: cost += .15; break;
			case VENTI: cost += .20; break;
			case GRANDE: cost += .25; break;
		}
		return cost;
	}

	public void setSize(Size size) {
		this.size = size;
		description = getSize() + " Decaf Coffee";
	}
}

