import java.io.Serializable;
import java.util.Objects;

public class PairFactory implements Serializable {
    public Pair<Integer, Integer> createPair(Pair<Integer, Integer> old, Integer xMove, Integer yMove) {
        if (Objects.isNull(old)) {
            return new Pair<Integer, Integer>(10, 10);
        } else {
            return new Pair<Integer, Integer>(old.getX() + xMove, old.getY() + yMove);
        }
    }
}
