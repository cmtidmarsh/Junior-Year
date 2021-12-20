import java.io.Serializable;

public class Pair<T1, T2> implements Serializable {
    private T1 p1;
    private T2 p2;

    public Pair(T1 x, T2 y) {
        this.p1 = x;
        this.p2 = y;
    }

    public void setPair(T1 x, T2 y) {
        this.p1 = x;
        this.p2 = y;
    }

    public T1 getX() {
        return this.p1;
    }

    public T2 getY() {
        return this.p2;
    }
}
