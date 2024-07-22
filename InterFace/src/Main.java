import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String fileName = "save.data";

        List<Design.Drawable> shapes = List.of(
                new Triangle(new Point(100, 30), new Point(150, 100), new Point(50, 100)),
                new Rectangle(new Point(100, 230), new Point(50, 260), new Point(50, 300), new Point(200, 300))
        );

        JFrame frame = new JFrame();
        Action panel = new Action(shapes);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("ファイル");

        JMenuItem saveItem = new JMenuItem("セーブ");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataSave.saveShapes(shapes, fileName);
            }
        });

        JMenuItem loadItem = new JMenuItem("ロード");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Design.Drawable> loadedShapes = DataSave.loadShapes(fileName);
                if (loadedShapes != null) {
                    panel.setShapes(loadedShapes);
                    panel.repaint();
                }
            }
        });

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
