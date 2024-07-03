import java.awt.*;

public abstract class Design {
    int size;

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
        void rotate();
    }
}
