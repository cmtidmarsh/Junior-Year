public class Cell {
    int state = 0; //0 for false, not 0 for true 1 is alive 0 is dead.
    int x;
    int y;
    Cell(int state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }
    public int getState() {
        return this.state;
    }
}
