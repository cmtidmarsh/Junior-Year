package DucksApp;

public class TurkeyAdapter implements Duck {
	Turkey turkey;
 
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
    
	public void quack() {
		try {
			turkey.gobble();
		} catch (java.rmi.RemoteException e) {
			System.out.println(e.detail);
		}
	}
  
	public void fly() {
		for(int i=0; i < 5; i++) {
			turkey.fly();
		}
	}
}
