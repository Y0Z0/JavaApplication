public class RefaMain {
    /*
    public static void main(String[] args) {
        Point p = new Point(1,2,4);
        System.out.println(p);
        System.out.println(p.getFrontPoint());
        System.out.println(p);
    }

    class List {
        String name;
    }
    class Point {
        int x;
        int y;
        int z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public Point getFrontPoint() {
            Point result = this;
            result.x = result.x + 1;
            return result;
        }
        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + "," + this.z + ")";
        }
    }
    */

    public static void main(String[] args) {
        Point p = new RefaMain().new Point(1, 2, 4);
        System.out.println(p);
        System.out.println(p.getFrontPoint());
        System.out.println(p);
    }

    class List {
        String name;
    }

    class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Point getFrontPoint() {
            return new Point(this.x + 1, this.y, this.z);
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + "," + this.z + ")";
        }
    }
}

