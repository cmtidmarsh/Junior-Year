public class DeadCell extends Cell{

    @Override
    public int getLiveNeighbors() {
        return 0;
    }

    @Override
    public void update() {
        super.lifeState = 0;
    }
}
