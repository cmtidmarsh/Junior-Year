import java.io.Serializable;

public class Pair<A,B> implements Serializable {
    private final A a;
    private final B b;

    public Pair (A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getFirst() { return a; }

    public B getSecond() { return b; }
}