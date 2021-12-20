class GameModel {
	
	Timer T;
	int[][] board;
	ArrayList<User> users;
	ArrayList<IGameObserver> observers;
	
	public int[][] getBoard() {}
	
	public void toggleCellManually(int row, int col) {}
	
	public void setObserver(Observer o) {}
	
	public void notifyObservers() {}
	
	public void setup() {}
	
	public void generateResources() {}
	
	public ArrayList<User> getUsers() {}
}