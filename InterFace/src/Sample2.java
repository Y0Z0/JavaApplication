import java.awt.*;
import javax.swing.*;
import java.util.List;

    public class Sample2 extends JPanel {
        static class Shape {
            int size;
        }

        public interface Drawable {
            void draw(Graphics g);
        }

        public interface Measurable {
            int getArea();
            int getPerimeter();
        }

        public interface ParallelMovable {
            void parallelMove();
        }

        public interface Movable extends ParallelMovable {
            void rotate();
        }

        static class Hero implements Drawable {
            @Override
            public void draw(Graphics g) {
                System.out.println("勇者を描きました。");
            }
        }

        static class Triangle extends Shape implements Drawable, Measurable, Movable {
            Point p1, p2, p3;

            Triangle(Point p1, Point p2, Point p3) {
                this.p1 = p1;
                this.p2 = p2;
                this.p3 = p3;
            }

            @Override
            public void draw(Graphics g) {
                g.drawPolygon(new int[]{p1.x, p2.x, p3.x}, new int[]{p1.y, p2.y, p3.y}, 3);
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
            public void parallelMove() {
                int dx = 1; // 任意の平行移動量
                int dy = 1; // 任意の平行移動量
                p1.translate(dx, dy);
                p2.translate(dx, dy);
                p3.translate(dx, dy);
                System.out.println("平行移動しました。");
            }

            @Override
            public void rotate() {
                double angle = 45; // 任意の回転角度
                double centerX = (p1.x + p2.x + p3.x) / 3.0;
                double centerY = (p1.y + p2.y + p3.y) / 3.0;

                p1 = rotatePoint(p1, centerX, centerY, angle);
                p2 = rotatePoint(p2, centerX, centerY, angle);
                p3 = rotatePoint(p3, centerX, centerY, angle);
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

        static class Rectangle extends Shape implements Drawable, Measurable, Movable {
            Point p1, p2, p3, p4;

            Rectangle(Point p1, Point p2, Point p3, Point p4) {
                this.p1 = p1;
                this.p2 = p2;
                this.p3 = p3;
                this.p4 = p4;
            }

            @Override
            public void draw(Graphics g) {
                g.drawPolygon(new int[]{p1.x, p2.x, p3.x, p4.x}, new int[]{p1.y, p2.y, p3.y, p4.y}, 4);
                System.out.println("四角形を描きました。");
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
            public void parallelMove() {
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

        private List<Drawable> shapes;

        public Sample2(List<Drawable> shapes) {
            this.shapes = shapes;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drawable shape : shapes) {
                shape.draw(g);
            }
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            List<Drawable> shapes = List.of(
                    new Triangle(new Point(100, 30), new Point(150, 100), new Point(50, 100)),
                    new Rectangle(new Point(100, 230), new Point(50, 260), new Point(50, 300), new Point(200, 300))
            );
            Sample2 panel = new Sample2(shapes);
            frame.add(panel);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }