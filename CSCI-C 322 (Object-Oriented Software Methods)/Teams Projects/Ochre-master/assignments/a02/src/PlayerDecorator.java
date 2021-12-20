import java.awt.*;

public class PlayerDecorator extends Player {
    PlayerDecorator(int id, int x, int y) {
        super(id, x, y);
    }

    public void setId(int id) {
        super.setId(id);
    }
    public int getId() {
        return super.getId();
    }

    public Point getPosition() {
        return super.getPosition();
    }

    public void setPosition(String lastInput) {
        super.setPosition(lastInput);
    }

    public void setResources(int resources) {
        super.setResources(resources);
    }

    public int getResources() {
        return super.getResources();
    }
}
