public class Pair<A,B> implements java.io.Serializable {
    private final A a;
    private final B b;

    Pair (A a, B b) { this.a = a; this.b = b; }

    A getFirst() { return a; }
    B getSecond() { return b; }
}
