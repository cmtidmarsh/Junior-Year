import java.awt.*;

public abstract class PlayerDecorator extends Player {
    private Player player;

    public PlayerDecorator(Player player) {
        super(player.getId(), player.getPosition().getFirst(), player.getPosition().getSecond());
        this.player = player;
    }
}

class GreenPlayer extends PlayerDecorator {
    Player player;

    public GreenPlayer(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public Color getColor() {
        return Color.green;
    }
}

class BluePlayer extends PlayerDecorator {
    Player player;

    public BluePlayer(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}

class RedPlayer extends PlayerDecorator {
    Player player;

    public RedPlayer(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }
}
