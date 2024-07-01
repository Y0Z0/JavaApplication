import java.awt.*;

public class Rectangle extends Design.Shape implements Design.Drawable, Design.Measurable, Design.Movable {
    Point p1, p2, p3, p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(0); // サイズの初期化は任意です
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
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p4.y) + p3.x * (p4.y - p1.y) + p4.x * (p1.y - p2.y)) / 2);
    }

    @Override
    public int getPerimeter() {
        return (int) (p1.distance(p2) + p2.distance(p3) + p3.distance(p4) + p4.distance(p1));
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
    public void rotate(double angle) {
        double centerX = (p1.x + p2.x + p3.x + p4.x) / 4.0;
        double centerY = (p1.y + p2.y + p3.y + p4.y) / 4.0;

        p1 = rotatePoint(p1, centerX, centerY, angle);
        p2 = rotatePoint(p2, centerX, centerY, angle);
        p3 = rotatePoint(p3, centerX, centerY, angle);
        p4 = rotatePoint(p4, centerX, centerY, angle);

        System.out.println("四角形を回転しました。");
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
