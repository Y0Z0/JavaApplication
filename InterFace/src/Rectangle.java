import java.awt.*;

public class Rectangle extends Design implements Design.Drawable, Design.Measurable, Design.Movable {
    Point p1, p2, p3, p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
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
    public void parallelMove(int dx, int dy) {
        p1.translate(dx, dy);
        p2.translate(dx, dy);
        p3.translate(dx, dy);
        p4.translate(dx, dy);
        System.out.println("四角形を平行移動しました。");
    }

    @Override
    public void rotate() {
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
