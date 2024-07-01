import javax.swing.*;
import java.awt.*;
import java.util.List;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        List<Desigh.Drawable> shapes = List.of(
                new Triangle(new Point(100, 30), new Point(150, 100), new Point(50, 100)),
                new Rectangle(new Point(100, 230), new Point(50, 260), new Point(50, 300), new Point(200, 300))
        );
        Action panel = new Action(shapes);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}