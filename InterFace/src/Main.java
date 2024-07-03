import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Design.Drawable> shapes = List.of(
                new Triangle(new Point(100, 30), new Point(150, 100), new Point(50, 100)),
                new Rectangle(new Point(100, 230), new Point(50, 260), new Point(50, 300), new Point(200, 300))
        );

        JFrame frame = new JFrame();
        Action panel = new Action(shapes);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
