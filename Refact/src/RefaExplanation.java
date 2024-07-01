import java.awt.*;

public class RefaExplanation {
    /*
    public static class Rectangle {
        private double width;
        private double height;
        private double x;   //左下のx座標
        private double y;   //左下のy座標

        public Rectangle(double width, double height, double x, double y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }

        public static void main(String[] args) {
            Rectangle rectangle = new Rectangle(3, 5, 0, 0);
            Point p = new Point(2,3);
            if(p.x >= rectangle.x &&
            p.x <= rectangle.x + rectangle.width &&
            p.y >= rectangle.y &&
            p.y <= rectangle.y + rectangle.height) {
                System.out.println("Inside");
            } else {
                System.out.println("Outside");
            }
        }
    }

    static class Point {
        public double x;
        public double y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

     */

    //ここからリファクタリング
    public static class NewRectangle {
        private double width;
        private double height;
        private double x;   //左下のx座標
        private double y;   //左下のy座標

        public NewRectangle(double width, double height, double x, double y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }

        public static void main(String[] args) {
            Rectangle rectangle = new Rectangle(3, 5, 0, 0);
            Point p = new Point(2,3);

            boolean isInsideX = p.x >= rectangle.x && p.x <= rectangle.x + rectangle.width;
            boolean isInsideY = p.y >= rectangle.y && p.y <= rectangle.y + rectangle.height;

            if(isInsideX && isInsideY) {
                System.out.println("Inside");
            } else {
                System.out.println("Outside");
            }
        }
    }

    static class NewPoint {
        public double x;
        public double y;

        public NewPoint(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
