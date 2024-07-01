import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class Action extends JPanel {
    private List<Shape.Drawable> shapes;

    public Action(List<Shape.Drawable> shapes) {
        this.shapes = shapes;

        JButton moveTriangleButton = new JButton("三角形を平行移動");
        moveTriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Shape.Drawable shape : shapes) {
                    if (shape instanceof Triangle) {
                        ((Shape.ParallelMovable) shape).parallelMove(1, 1);
                    }
                }
                repaint();
            }
        });

        JButton moveRectangleButton = new JButton("四角形を平行移動");
        moveRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Shape.Drawable shape : shapes) {
                    if (shape instanceof Rectangle) {
                        ((Shape.ParallelMovable) shape).parallelMove(1, 1);
                    }
                }
                repaint();
            }
        });

        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(moveTriangleButton);
        buttonPanel.add(moveRectangleButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape.Drawable shape : shapes) {
            shape.draw(g);
        }
    }
}
