public class LiveCell extends Cell{
    int lifeState;

    @Override
    public int getLiveNeighbors() {
        return 0;
    }

    @Override
    public void update() {
        super.lifeState = 1;
    }
}
