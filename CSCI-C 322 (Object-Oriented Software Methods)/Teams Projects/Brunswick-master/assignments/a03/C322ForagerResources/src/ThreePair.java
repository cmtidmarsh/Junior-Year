public class ThreePair<A,B,C> {
    private final A a;
    private final B b;
    private final C c;

    ThreePair(A a, B b, C c) { this.a = a; this.b = b; this.c = c; }

    A getFirst() { return a; }
    B getSecond() { return b; }
    C getThird() { return c; }
}
