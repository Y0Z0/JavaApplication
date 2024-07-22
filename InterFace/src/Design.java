import java.awt.*;
import java.io.Serializable;

public abstract class Design implements Serializable {
    private static final long serialVersionUID = 1L;

    public interface Drawable {
        void draw(Graphics g);
    }

    public interface Measurable {
        int getArea();
        int getPerimeter();
    }

    public interface ParallelMovable {
        void parallelMove(int dx, int dy);
    }

    public interface Movable extends ParallelMovable {
        void rotate(double angle);
    }
}
