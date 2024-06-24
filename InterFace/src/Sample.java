import java.awt.*;

public class Sample {
    static class Shape {
        int size;
    }

    interface Drawable {
        void draw();
    }

    interface Measurable {
        int getArea();
        int getPerimeter();
    }

    interface ParallelMovable {
        void parallelMove();
    }

    interface Movable extends ParallelMovable{
        void rotate();
    }

    static class Hero implements Drawable {
        @Override
        public void draw() {
            System.out.println("勇者を描きました。");
        }
    }


    class Triangle extends Shape implements Drawable, Measurable, Movable {
        Point p1;
        Point p2;
        Point p3;
    }

    public void main(String[] args){
        Sample.Drawable h = new Sample.Hero();
        h.draw();

        Triangle t1 = new Triangle(
                new Point(3,2),
                new Point(1,3),
                new Point(1,1));

        t1.draw();
        System.out.println(t1.getArea());
    }


}
