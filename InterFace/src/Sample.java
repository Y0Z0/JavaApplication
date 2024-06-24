import java.awt.*;
import java.util.List;

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

    interface Movable extends ParallelMovable {
        void rotate();
    }

    static class Hero implements Drawable {
        @Override
        public void draw() {
            System.out.println("勇者を描きました。");
        }
    }

    static class Triangle extends Shape implements Drawable, Measurable, Movable {
        Point p1;
        Point p2;
        Point p3;

        Triangle(Point p1, Point p2, Point p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        @Override
        public void draw() {
            System.out.println("三角形を描きました。");
        }

        @Override
        public int getArea() {
            return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2);
        }

        @Override
        public int getPerimeter() {
            return (int) (p1.distance(p2) + p2.distance(p3) + p3.distance(p1));
        }

        @Override
        public void parallelMove(){
            int dx = 1; // 任意の平行移動量
            int dy = 1; // 任意の平行移動量
            p1.translate(dx, dy);
            p2.translate(dx, dy);
            p3.translate(dx, dy);
            System.out.println("平行移動しました。");
        }

        @Override
        public void rotate(){
            double angle = 45; // 任意の回転角度
            double centerX = (p1.x + p2.x + p3.x) / 3.0;
            double centerY = (p1.y + p2.y + p3.y) / 3.0;

            p1 = rotatePoint(p1, centerX, centerY, angle);
            p2 = rotatePoint(p2, centerX, centerY, angle);
            p3 = rotatePoint(p3, centerX, centerY, angle);

            System.out.println("回転しました。");
        }

        private Point rotatePoint(Point p, double centerX, double centerY, double angle) {
            double rad = Math.toRadians(angle);
            double cos = Math.cos(rad);
            double sin = Math.sin(rad);
            int x = (int) (centerX + (p.x - centerX) * cos - (p.y - centerY) * sin);
            int y = (int) (centerY + (p.x - centerX) * sin + (p.y - centerY) * cos);
            return new Point(x, y);
        }
    }

    public static void main(String[] args) {
        Drawable h = new Hero();
        h.draw();

        Triangle t1 = new Triangle(
                new Point(3, 2),
                new Point(1, 3),
                new Point(1, 1)
        );

        t1.draw();

        Drawable t2 = new Triangle(new Point(3,2),new Point(1,3),new Point(1,1));
        List<Drawable> list = List.of(t2,h);
        for(Drawable e: list) {
            e.draw();
        }

        System.out.println("面積: " + t1.getArea());
        System.out.println("周囲長: " + t1.getPerimeter());
    }
}
