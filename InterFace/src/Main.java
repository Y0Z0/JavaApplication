import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

public class Main {
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

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shapes.ser"))) {
                    out.writeObject(shapes);
                    System.out.println("Shapes saved.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("shapes.ser"))) {
                    List<Design.Drawable> loadedShapes = (List<Design.Drawable>) in.readObject();
                    panel.setShapes(loadedShapes);
                    panel.repaint();
                    System.out.println("Shapes loaded.");
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
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
