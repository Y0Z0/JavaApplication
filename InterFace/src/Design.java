import java.awt.*;

public abstract class Design {
    public static abstract class Shape {
        int size;

        public Shape(int size) {
            this.size = size;
        }
    }

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
