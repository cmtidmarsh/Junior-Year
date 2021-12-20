package starbuzzWithSizes;
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = getSize() +" House Blend Coffee";
	}
 
	public double cost() {
		double cost = .89;
		switch(this.getSize()){
			case TALL: cost += .05; break;
			case VENTI: cost += .10; break;
			case GRANDE: cost += .15; break;
		}
		return cost;
	}

	public void setSize(Size size) {
		this.size = size;
		description = getSize() + " House Blend Coffee";
	}
}

