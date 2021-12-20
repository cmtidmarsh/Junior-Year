public abstract class Cell {
    public int lifeState;

    public abstract int getLiveNeighbors();
    public abstract void update();
}
